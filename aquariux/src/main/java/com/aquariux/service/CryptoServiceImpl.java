package com.aquariux.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aquariux.repository.CryptoRepository;
import com.aquariux.entity.Crypto_Details;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class CryptoServiceImpl implements CryptoService {

	@Autowired
	private CryptoRepository cryptoRepo;
	
	@Scheduled(fixedRate = 10000)
	public void getPrices() {
		String binanceURL = "https://api.binance.com/api/v3/ticker/bookTicker";
		String huobiURL = "https://api.huobi.pro/market/tickers";
		try {
			//Binance
			ResponseEntity<JsonNode> binanceResponse = new RestTemplate().getForEntity(binanceURL, JsonNode.class);
			JsonNode binanceData = binanceResponse.getBody();
			
			//Huobi
			ResponseEntity<JsonNode> huobiResponse = new RestTemplate().getForEntity(huobiURL, JsonNode.class);
			JsonNode huobiData = huobiResponse.getBody().get("data");
			
			updatePrice("BTCUSDT", binanceData, huobiData);
			updatePrice("ETHUSDT", binanceData, huobiData);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void updatePrice(String pair, JsonNode binance, JsonNode huobi) {
		BigDecimal binanceBid = BigDecimal.ZERO;
		BigDecimal binanceAsk = BigDecimal.ZERO;
		BigDecimal huobiBid = BigDecimal.ZERO;
		BigDecimal huobiAsk = BigDecimal.ZERO;
		
		for (JsonNode ticker : binance) {
			if(pair.equalsIgnoreCase(ticker.get("symbol").asText())) {
				binanceBid = new BigDecimal(ticker.get("bidPrice").asText());
				binanceAsk = new BigDecimal(ticker.get("askPrice").asText());
			}
		}
		
		for (JsonNode ticker : huobi) {
			if(pair.equalsIgnoreCase(ticker.get("symbol").asText())) {
				huobiBid = new BigDecimal(ticker.get("bid").asText());
				huobiAsk = new BigDecimal(ticker.get("ask").asText());
			}
		}
		
		BigDecimal bestBid = binanceBid.max(huobiBid);
		BigDecimal bestAsk = binanceAsk.min(huobiAsk);
		
		Crypto_Details aggPrice = new Crypto_Details();
		aggPrice.setCryptoPair(pair);
		aggPrice.setBidPrice(bestBid);
		aggPrice.setAskPrice(bestAsk);
		aggPrice.setLastUpdated(LocalDateTime.now());
		cryptoRepo.save(aggPrice);
				
	}
	
	@Override
	public Crypto_Details getLatestPrice(String pair) {
		return cryptoRepo.findById(pair).orElseThrow();
	}
}
