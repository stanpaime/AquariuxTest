package com.aquariux.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aquariux.entity.Transactions;
import com.aquariux.service.TransactionsService;

@RestController
@RequestMapping("/api/trade")
public class TransactionsController {

	@Autowired
	private TransactionsService transactionsService;
	
	@PostMapping
	public ResponseEntity<String> trade(@RequestParam Long userId,
									@RequestParam String pair,
									@RequestParam String type,
									@RequestParam BigDecimal amount) {
		
		return transactionsService.trade(userId, pair, type, amount);
	}
	
	@GetMapping("/transactions") 
		public ResponseEntity<List<Transactions>> getTransactionsById(@RequestParam Long userId) {
			return ResponseEntity.ok(transactionsService.getListOfUserTransactions(userId));
		}
}
