package org.gauri.services.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConvertorController {

	private Logger LOG=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CurrencyExchangeServiceProxy  proxy;
	
	
	@GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		// Problem to call other microservice
		RestTemplate restTemplate=new RestTemplate();
		Map<String,String> urlVariables=new HashMap<>();
		urlVariables.put("from", from);
		urlVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity=restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
				CurrencyConversionBean.class, urlVariables);
		
		
		CurrencyConversionBean currencyConversionBean=responseEntity.getBody();
		
		
		return new CurrencyConversionBean(currencyConversionBean.getId(), 
				from, to, currencyConversionBean.getConversionMultiple(), quantity, 
				quantity.multiply(currencyConversionBean.getConversionMultiple()), currencyConversionBean.getPort());
		
	}
	
	
	
	@GetMapping("/currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		LOG.info("covert currency from {} to {} for quantity {}" , from , to, quantity);
		CurrencyConversionBean currencyConversionBean=proxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConversionBean(currencyConversionBean.getId(), 
				from, to, currencyConversionBean.getConversionMultiple(), quantity, 
				quantity.multiply(currencyConversionBean.getConversionMultiple()), currencyConversionBean.getPort());
		
	}
}
