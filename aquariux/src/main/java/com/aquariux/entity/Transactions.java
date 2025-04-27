package com.aquariux.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transacId;
	
	@ManyToOne
	private User_Details user;
	
	private String cryptoPair; // BTCUSDT or ETHUSDT
	private String transacType; //BUY or SELL
	private BigDecimal transacAmount; //Amount of crypto 
	private BigDecimal price; //Price in USDT
	private String transacStatus; //Pending, Completed, Cancelled
	private LocalDateTime timestamp;
	
	public Long getTransacId() {
		return transacId;
	}
	public void setTransacId(Long transacId) {
		this.transacId = transacId;
	}
	public User_Details getUser() {
		return user;
	}
	public void setUser(User_Details user) {
		this.user = user;
	}
	public String getCryptoPair() {
		return cryptoPair;
	}
	public void setCryptoPair(String cryptoPair) {
		this.cryptoPair = cryptoPair;
	}
	public String getTransacType() {
		return transacType;
	}
	public void setTransacType(String transacType) {
		this.transacType = transacType;
	}
	public BigDecimal getTransacAmount() {
		return transacAmount;
	}
	public void setTransacAmount(BigDecimal transacAmount) {
		this.transacAmount = transacAmount;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getTransacStatus() {
		return transacStatus;
	}
	public void setTransacStatus(String transacStatus) {
		this.transacStatus = transacStatus;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	
}
