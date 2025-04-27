package com.aquariux.service;

import java.math.BigDecimal;
import java.util.Map;

public interface UserService {
	
	// Retrieve wallet balance
		Map<String, BigDecimal> getWalletBalance(Long userId);
}
