package com.aquariux.service;

import java.math.BigDecimal;
import java.util.Map;

import com.aquariux.entity.User_Details;

public interface UserService {
	
	// Retrieve wallet balance
		Map<String, BigDecimal> getWalletBalance(Long userId);

		User_Details getUser(Long userId);
}
