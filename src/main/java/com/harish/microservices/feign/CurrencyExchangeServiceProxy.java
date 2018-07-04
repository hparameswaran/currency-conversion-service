package com.harish.microservices.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.harish.microservices.entity.CurrencyConversionBean;


//@FeignClient(name="currency-exchange-service", url="localhost:8000")    <-- Before Eureka Server
//@FeignClient(name="currency-exchange-service")   <--Before Zull
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")    <-- Before Zull
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retreiveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);
		
	
}
