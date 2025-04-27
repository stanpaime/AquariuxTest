package com.aquariux.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquariux.entity.Crypto_Details;
import com.aquariux.entity.Transactions;
import com.aquariux.entity.User_Details;
import com.aquariux.repository.CryptoRepository;
import com.aquariux.repository.TransactionsRepository;
import com.aquariux.repository.UserRepository;

@Service
public class TransactionsServiceImpl implements TransactionsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TransactionsRepository transactionsRepository;
	
	@Autowired
	private CryptoRepository cryptoRepo;
	
	@Override
	public void trade(Long userId, String pair, String type, BigDecimal amount) {
		User_Details user = userRepository.findById(userId).orElseThrow();
		Crypto_Details priceData = cryptoRepo.findById(pair).orElseThrow();
		
		BigDecimal price;
		
		if ("BUY".equalsIgnoreCase(type)) {
			price = priceData.getAskPrice();
		} else {
			price = priceData.getBidPrice();
		}
		
		
//		BigDecimal price = "BUY".equalsIgnoreCase(type) ? priceData.getAskPrice() : priceData.getBidPrice();
		BigDecimal totalCost = price.multiply(amount);
		
		if ("BUY".equalsIgnoreCase(type)) {
			if (user.getUsdtBalance().compareTo(totalCost) < 0) throw new RuntimeException("Insufficient USDT");
			
			user.setUsdtBalance(user.getUsdtBalance().subtract(totalCost));
			
			if ("BTCUSDT".equalsIgnoreCase(pair)) user.setBtcBalance(user.getBtcBalance().add(amount));
			else if ("ETHUSDT".equalsIgnoreCase(pair)) user.setEthBalance(user.getEthBalance().add(amount));
			
		} else if ("SELL".equalsIgnoreCase(type)) {
			if ("BTCUSDT".equalsIgnoreCase(pair)) {
				if (user.getBtcBalance().compareTo(amount) < 0) throw new RuntimeException("Insufficient BTC");
				
				user.setBtcBalance(user.getBtcBalance().subtract(amount));
				
			} else if ("ETHUSDT".equalsIgnoreCase(pair)) {
				if (user.getEthBalance().compareTo(amount) < 0) throw new RuntimeException("Insufficient ETH");
				
				user.setEthBalance(user.getEthBalance().subtract(amount));
				
			}
			user.setUsdtBalance(user.getUsdtBalance().add(totalCost));
		}
		
		Transactions tx = new Transactions();
		tx.setUser(user);
		tx.setCryptoPair(pair);
		tx.setTransacType(type);
		tx.setTransacAmount(amount);
		tx.setPrice(price);
		tx.setTimestamp(LocalDateTime.now());
		
		transactionsRepository.save(tx);
		userRepository.save(user);
	}
	
	@Override
	public List<Transactions> getListOfUserTransactions(Long userId) {
		return transactionsRepository.findByUserId(userId);
	}
}
