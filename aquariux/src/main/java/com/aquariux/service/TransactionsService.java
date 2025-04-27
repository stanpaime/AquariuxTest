package com.aquariux.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aquariux.entity.Transactions;

public interface TransactionsService {
	
	// Create a trade transaction
	ResponseEntity<String> trade(Long userId, String pair, String type, BigDecimal amount);
	
	// List all the user's transaction history
	List<Transactions> getListOfUserTransactions(Long userId);
}
