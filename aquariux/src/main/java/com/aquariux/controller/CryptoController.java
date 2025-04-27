package com.aquariux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aquariux.entity.Crypto_Details;
import com.aquariux.service.CryptoService;

@RestController
@RequestMapping("/api/crypto")
public class CryptoController {

	@Autowired
	private CryptoService cryptoService;
	
	@GetMapping("/price") 
	public ResponseEntity<Crypto_Details> getLatestPrice(@RequestParam String pair) {
		return ResponseEntity.ok(cryptoService.getLatestPrice(pair));
	}
}
