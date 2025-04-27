package com.aquariux.controller;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aquariux.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/wallet") 
	public ResponseEntity<Map<String, BigDecimal>> getWalletBalById(@RequestParam Long userId) {
		return ResponseEntity.ok(userService.getWalletBalance(userId));
	}
}
