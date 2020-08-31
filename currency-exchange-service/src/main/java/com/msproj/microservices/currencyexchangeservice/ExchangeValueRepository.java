package com.msproj.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByCountry(String country);
	ExchangeValue findByCurrency(String currency);
	
}
