package com.aquariux.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquariux.entity.User_Details;
import com.aquariux.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Map<String, BigDecimal> getWalletBalance(Long userId) {
		User_Details user = userRepository.findById(userId).orElseThrow();
		Map<String, BigDecimal> wallet = new HashMap<>();
		wallet.put("USDT", user.getUsdtBalance());
		wallet.put("BTC", user.getBtcBalance());
		wallet.put("ETH", user.getEthBalance());
		return wallet;
	}
	
	
}