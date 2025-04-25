package com.aquariux.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Crypto_Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cryptoId;
	private String cryptoName;
	private String cryptoTicker;
	private double cryptoPrice;
	
	public int getCryptoId() {
		return cryptoId;
	}
	public void setCryptoId(int cryptoId) {
		this.cryptoId = cryptoId;
	}
	public String getCryptoName() {
		return cryptoName;
	}
	public void setCryptoName(String cryptoName) {
		this.cryptoName = cryptoName;
	}
	public String getCryptoTicker() {
		return cryptoTicker;
	}
	public void setCryptoTicker(String cryptoTicker) {
		this.cryptoTicker = cryptoTicker;
	}
	public double getCryptoPrice() {
		return cryptoPrice;
	}
	public void setCryptoPrice(double cryptoPrice) {
		this.cryptoPrice = cryptoPrice;
	}
	
	
}
