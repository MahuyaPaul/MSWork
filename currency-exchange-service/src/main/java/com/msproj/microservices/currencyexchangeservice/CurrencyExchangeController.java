package com.msproj.microservices.currencyexchangeservice;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController 
public class CurrencyExchangeController {
	@Autowired
	private Environment environment;
	@Autowired  
	private ExchangeValueRepository repository; 

	@GetMapping("/currency-exchange/currency/{currency}") 
	public ExchangeValue retrieveExchangeValue(@PathVariable String currency) 
																									
	{
		//ExchangeValue exchangeValue = new ExchangeValue(1000L, currency, "IND", BigDecimal.valueOf(65));
		ExchangeValue exchangeValue = repository.findByCurrency(currency);  
		//setting the port
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
	
	// -------------------Get Conversion Factor between two currencies---------------------------------------------
	@GetMapping("/currency-exchange/fromCurrency/{fromCurrency}/toCurrency/{toCurrency}")
		public ExchangeValue getConversionFactorBetweenTwoCurrencies(@PathVariable String fromCurrency, @PathVariable String toCurrency) {

			ExchangeValue fromCurrencyEx = repository.findByCurrency(fromCurrency);
			ExchangeValue toCurrencyEx   = repository.findByCurrency(toCurrency);
			ExchangeValue resultCurrencyEx = new ExchangeValue();
			
			
			Double resultFactor = Double.valueOf(fromCurrencyEx.getConversionFactor() / toCurrencyEx.getConversionFactor());
			resultCurrencyEx.setPort(0);
			resultCurrencyEx.setCountry(fromCurrencyEx.getCountry()+ " to " + toCurrencyEx.getCountry());
			resultCurrencyEx.setCurrency(fromCurrency + " to " + toCurrency);
			resultCurrencyEx.setId(fromCurrencyEx.getId());
			resultCurrencyEx.setConversionFactor(resultFactor);
			
			return resultCurrencyEx;
		}
	
	// -------------------Add Conversion Factor---------------------------------------------
	@RequestMapping(value = "/currency-exchange/country/{country}/currency/{currency}/conversionFactor/{conversionFactor}", method = RequestMethod.PUT)
		public void addConversionFactor(@PathVariable String country,
				                                          @PathVariable String currency, 
				                                          @PathVariable Double conversionFactor) {
			
			//ExchangeValue currencyEx = repository.findByCountryCode(countryCode);

			ExchangeValue addCurrencyEx = new ExchangeValue();
			addCurrencyEx.setId((long) 10003);
			addCurrencyEx.setCountry(country);
			addCurrencyEx.setCurrency(currency);
			addCurrencyEx.setConversionFactor(conversionFactor);
			addCurrencyEx.setPort(0);
			repository.save(addCurrencyEx);
		}
	
	// -------------------Update Conversion Factor---------------------------------------------
		@RequestMapping(value = "/currency-exchange/country/{country}/currency/{currency}/conversionFactor/{conversionFactor}", method = RequestMethod.POST)
		public void updateConversionFactor(@PathVariable String countryCode, @PathVariable String currencyCode, @PathVariable Double conversionFactor) {
			ExchangeValue upCurrencyEx = repository.findByCountry(countryCode);
			upCurrencyEx.setCountry(countryCode);
			upCurrencyEx.setCurrency(currencyCode);
			upCurrencyEx.setConversionFactor(conversionFactor);
			upCurrencyEx.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			repository.save(upCurrencyEx);

		}


}
