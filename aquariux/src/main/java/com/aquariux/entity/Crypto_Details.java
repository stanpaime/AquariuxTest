package com.aquariux.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Crypto_Details {
	
	@Id
	private String cryptoPair; //BTCUSDT or ETHUSDT
	private BigDecimal bidPrice;
	private BigDecimal askPrice;
	private LocalDateTime lastUpdated;
	
	public String getCryptoPair() {
		return cryptoPair;
	}
	public void setCryptoPair(String cryptoPair) {
		this.cryptoPair = cryptoPair;
	}
	public BigDecimal getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(BigDecimal bidPrice) {
		this.bidPrice = bidPrice;
	}
	public BigDecimal getAskPrice() {
		return askPrice;
	}
	public void setAskPrice(BigDecimal askPrice) {
		this.askPrice = askPrice;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
}
