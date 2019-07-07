package org.gauri.services.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchnageController {

	private Logger LOG=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;  
	
	@Autowired
	private ExchangeValueRepository repository;
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		LOG.info("covert currency from {} to {}" , from , to);
		
		ExchangeValue ex=repository.findByFromAndTo(from, to);
		ex.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return ex;
	}
}
