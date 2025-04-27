package com.aquariux;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.aquariux.entity.Crypto_Details;
import com.aquariux.entity.User_Details;
import com.aquariux.repository.CryptoRepository;
import com.aquariux.repository.TransactionsRepository;
import com.aquariux.repository.UserRepository;
import com.aquariux.service.TransactionsService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
public class AquariuxApplication {

	public static void main(String[] args) {
		SpringApplication.run(AquariuxApplication.class, args);
	}
	
	 @Bean
	    public CommandLineRunner loadSampleData(UserRepository userRepository, 
	                                            CryptoRepository priceRepo, 
	                                            TransactionsService tradingService) {
	        return args -> {
	            User_Details user = new User_Details();
	            user.setUserId(1L);
	            user.setName("Alice");
	            userRepository.save(user);

	            Crypto_Details btcPrice = new Crypto_Details();
	            btcPrice.setCryptoPair("BTCUSDT");
	            btcPrice.setAskPrice(new BigDecimal("30000"));
	            btcPrice.setBidPrice(new BigDecimal("29950"));
	            btcPrice.setLastUpdated(LocalDateTime.now());
	            priceRepo.save(btcPrice);

	            Crypto_Details ethPrice = new Crypto_Details();
	            ethPrice.setCryptoPair("ETHUSDT");
	            ethPrice.setAskPrice(new BigDecimal("2000"));
	            ethPrice.setBidPrice(new BigDecimal("1980"));
	            ethPrice.setLastUpdated(LocalDateTime.now());
	            priceRepo.save(ethPrice);

	            // Now safely perform trades after everything is saved
//	            tradingService.trade(1L, "BTCUSDT", "BUY", new BigDecimal("0.5"));
//	            tradingService.trade(1L, "ETHUSDT", "BUY", new BigDecimal("5"));
//	            tradingService.trade(1L, "BTCUSDT", "SELL", new BigDecimal("0.1"));
	        };
	    }
}
