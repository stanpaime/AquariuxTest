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
}
