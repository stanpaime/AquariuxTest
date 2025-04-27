package com.aquariux.service;

import com.aquariux.entity.Crypto_Details;

public interface CryptoService {
	
	// Get latest best price of the cryptos
	Crypto_Details getLatestPrice(String pair);
}
