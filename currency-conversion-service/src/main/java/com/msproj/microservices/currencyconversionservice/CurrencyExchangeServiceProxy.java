
package com.msproj.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "currency-exchange-service", fallback = CurrencyExchangeServiceProxy_Fallback.class)
//@RibbonClient(name="currency-exchange-service") 
public interface CurrencyExchangeServiceProxy {

	// -------------------Get Conversion Factor for a
	// currency---------------------------------------------
	@RequestMapping(value = "/currency-exchange/currency/{currency}", method = RequestMethod.GET)
	public CurrencyExchangeBean retrieveExchangeValue(@PathVariable("currency") String currency);

	// -------------------Get Conversion Factor between two
	// currencies---------------------------------------------
//	@RequestMapping(value = "/currency-exchange/fromCurrency/{fromCurrency}/toCurrency/{toCurrency}", method = RequestMethod.GET)
//	public CurrencyExchangeBean getConversionFactorBetweenTwoCurrencies(@PathVariable String fromCurrency,
//			@PathVariable String toCurrency);

}
