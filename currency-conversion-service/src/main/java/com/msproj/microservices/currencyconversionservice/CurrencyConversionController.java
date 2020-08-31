package com.msproj.microservices.currencyconversionservice;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
//	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}") // where {from} and {to} represents the
//																				// column
////returns a bean back
//	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
//			@PathVariable BigDecimal quantity) {
////setting variables to currency exchange service
//		Map<String, String> uriVariables = new HashMap<>();
//		uriVariables.put("from", from);
//		uriVariables.put("to", to);
////calling the currency exchange service
//		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
//				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
//				uriVariables);
//		CurrencyConversionBean response = responseEntity.getBody();
////creating a new response bean and getting the response back and taking it into Bean
//		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
//				quantity.multiply(response.getConversionMultiple()), response.getPort());
//	}
	
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	// -------------------Get Conversion Factor and calculate total amount for a currency---------------------------------------------
	@RequestMapping(value = "/currency-exchange/amount/{amount}/currency/{currency}", method = RequestMethod.GET)
	public CurrencyConversionBean getConversionFactor (@PathVariable Double amount, @PathVariable String currency) {
		
		CurrencyExchangeBean forexResponse = proxy.getConversionFactor(currency);
		CurrencyConversionBean conversionResponse = new CurrencyConversionBean();
		
		Double finalAmount = forexResponse.getConversionFactor()*amount;
		
		
		conversionResponse.setFromCurrency(forexResponse.getCurrency());
		conversionResponse.setToCurrency("USD");
		conversionResponse.setConversionFactor(forexResponse.getConversionFactor());
		conversionResponse.setAmount(amount);
		conversionResponse.setFinalAmount(finalAmount);
		conversionResponse.setPort(forexResponse.getPort());
		
		return conversionResponse;
			
	}
	
	//-------------------Get Conversion Factor between two currencies and calculate total amount ---------------------------------------------
	@RequestMapping(value = "/currency-exchange/amount/{amount}/fromCurrency/{fromCurrency}/toCurrency/{toCurrency}", method = RequestMethod.GET)
	public CurrencyConversionBean convertCurrency(@PathVariable Double amount,
			                                      @PathVariable String fromCurrency,
			                                      @PathVariable String toCurrency) {
		
		CurrencyConversionBean conversionResponse = new CurrencyConversionBean();
		CurrencyExchangeBean forexResponse = proxy.getConversionFactorBetweenTwoCurrencies(fromCurrency, toCurrency);		
		
		Double finalAmount = forexResponse.getConversionFactor()*amount;		
		
		conversionResponse.setFromCurrency(fromCurrency);
		conversionResponse.setToCurrency(toCurrency);
		conversionResponse.setConversionFactor(forexResponse.getConversionFactor());
		conversionResponse.setAmount(amount);
		conversionResponse.setFinalAmount(finalAmount);
		conversionResponse.setPort(forexResponse.getPort());
		
		return conversionResponse;
		
		
	}

	
	
}
