package com.aquariux.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transacId;
	private int accountId;
	private String transacType;
	private double transacAmount;
	private String transacDate;
	private String transacStatus;
	
	public int getTransacId() {
		return transacId;
	}
	public void setTransacId(int transacId) {
		this.transacId = transacId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getTransacType() {
		return transacType;
	}
	public void setTransacType(String transacType) {
		this.transacType = transacType;
	}
	public double getTransacAmount() {
		return transacAmount;
	}
	public void setTransacAmount(double transacAmount) {
		this.transacAmount = transacAmount;
	}
	public String getTransacDate() {
		return transacDate;
	}
	public void setTransacDate(String transacDate) {
		this.transacDate = transacDate;
	}
	public String getTransacStatus() {
		return transacStatus;
	}
	public void setTransacStatus(String transacStatus) {
		this.transacStatus = transacStatus;
	}
	
}
