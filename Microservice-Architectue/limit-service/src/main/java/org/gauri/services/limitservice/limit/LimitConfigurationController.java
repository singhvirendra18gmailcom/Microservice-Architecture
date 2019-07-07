package org.gauri.services.limitservice.limit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class LimitConfigurationController {

	@Autowired
	Configuration configuarion;
	
	@GetMapping("/limits")
	public LimitConfiguration limits() {
		return new LimitConfiguration(configuarion.getMinimum(),configuarion.getMaximum());
		
	}
}
