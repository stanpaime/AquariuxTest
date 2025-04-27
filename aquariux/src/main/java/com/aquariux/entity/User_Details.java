package com.aquariux.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User_Details {
	
	@Id
	private Long id;
	private String name;
	private BigDecimal usdtBalance = new BigDecimal("50000.00");
	private BigDecimal btcBalance = BigDecimal.ZERO;
	private BigDecimal ethBalance = BigDecimal.ZERO;
	
	public Long getUserId() {
		return id;
	}
	public void setUserId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getUsdtBalance() {
		return usdtBalance;
	}
	public void setUsdtBalance(BigDecimal usdtBalance) {
		this.usdtBalance = usdtBalance;
	}
	public BigDecimal getBtcBalance() {
		return btcBalance;
	}
	public void setBtcBalance(BigDecimal btcBalance) {
		this.btcBalance = btcBalance;
	}
	public BigDecimal getEthBalance() {
		return ethBalance;
	}
	public void setEthBalance(BigDecimal ethBalance) {
		this.ethBalance = ethBalance;
	}
	
	
	
	
}
