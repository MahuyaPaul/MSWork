package com.msproj.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	//private Long   id;
	private String fromCurrency;
	private String toCurrency;
	private Double conversionFactor;
	private Double amount;
	private Double finalAmount;

	private int port;

	public CurrencyConversionBean() {

	}

	public CurrencyConversionBean(String fromCurrency, String toCurrency, Double conversionFactor,
			Double amount, Double finalAmount, int port) {
		super();
		//this.id = id;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.conversionFactor = conversionFactor;
		this.amount = amount;
		this.finalAmount = finalAmount;
		this.port = port;
	}

	/*
	 * public Long getId() { return id; }
	 * 
	 * public void setId(Long id) { this.id = id; }
	 */

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

}
