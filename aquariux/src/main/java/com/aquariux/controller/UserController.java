package com.aquariux.controller;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aquariux.entity.User_Details;
import com.aquariux.repository.UserRepository;
import com.aquariux.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/{userId}")
	public ResponseEntity<User_Details> getUser(@PathVariable Long userId) {
		return ResponseEntity.ok(userService.getUser(userId));
	}
	
	@GetMapping("/wallet") 
	public ResponseEntity<Map<String, BigDecimal>> getWalletBalById(@RequestParam Long userId) {
		return ResponseEntity.ok(userService.getWalletBalance(userId));
	}
}
