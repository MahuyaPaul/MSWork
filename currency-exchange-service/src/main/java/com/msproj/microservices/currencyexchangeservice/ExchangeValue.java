package com.msproj.microservices.currencyexchangeservice;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Exchange_Value")
public class ExchangeValue 
{
@Id
@Column(name="id")
private Long id;
@Column(name="currency")
private String currency;
@Column(name="country")
private String country;
@Column(name="conversion_factor")
private double conversionFactor;
@Column(name="port")
private int port;
public ExchangeValue()
{	
}
//generating constructor using fields
public ExchangeValue(Long id, String currency, String country, double conversionFactor) 
{
super();
this.id = id;
this.currency = currency;
this.country = country;
this.conversionFactor = conversionFactor;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public double getConversionFactor() {
	return conversionFactor;
}
public void setConversionFactor(double conversionFactor) {
	this.conversionFactor = conversionFactor;
}
public int getPort() {
	return port;
}
public void setPort(int port) {
	this.port = port;
}

}
