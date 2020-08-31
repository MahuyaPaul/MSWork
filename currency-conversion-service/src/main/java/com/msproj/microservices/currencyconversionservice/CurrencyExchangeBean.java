/**
 * 
 */
package com.msproj.microservices.currencyconversionservice;

public class CurrencyExchangeBean {
	
	private Long id;
	private String countryCode;
	private String currency;
	private Double conversionFactor;
	private int port;
	
	public CurrencyExchangeBean() {

	}

	public CurrencyExchangeBean(Long id, String countryCode, String currency, Double conversionFactor) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.currency = currency;
		this.conversionFactor = conversionFactor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	@Override
	public String toString() {
		return "CurrencyExchange [id=" + id + ", countryCode=" + countryCode + ", conversionFactor=" + conversionFactor
				+ "]";
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
