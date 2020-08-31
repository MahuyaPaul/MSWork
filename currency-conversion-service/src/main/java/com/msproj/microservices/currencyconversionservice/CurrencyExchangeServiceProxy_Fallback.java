package com.msproj.microservices.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


/**
 * @author Som
 *
 */
@Component
public class CurrencyExchangeServiceProxy_Fallback implements CurrencyExchangeServiceProxy {
	
	@Autowired
	private Environment environment;

	@Override
	public CurrencyExchangeBean getConversionFactor(String countryCode) {
		System.out.println("getConversionFactor :: Returning default fallback conversionFactor value : 0.0");
		CurrencyExchangeBean defaultValues = new CurrencyExchangeBean();
		defaultValues.setId(null);
		defaultValues.setCountryCode("Fallback_Country");
		defaultValues.setCurrency("Fallback_Currency");
		defaultValues.setConversionFactor(0.00);
		defaultValues.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		return defaultValues;
	}

	@Override
	public CurrencyExchangeBean getConversionFactorBetweenTwoCurrencies(String fromCurrency, String toCurrency) {
		System.out.println("getConversionFactorBetweenTwoCurrencies :: Returning default fallback conversionFactor value : 0.0");
		CurrencyExchangeBean defaultValues = new CurrencyExchangeBean();
		defaultValues.setId(null);
		defaultValues.setCountryCode("Fallback_Country");
		defaultValues.setCurrency("Fallback_Currency");
		defaultValues.setConversionFactor(0.00);
		defaultValues.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		return defaultValues;
	}

}
