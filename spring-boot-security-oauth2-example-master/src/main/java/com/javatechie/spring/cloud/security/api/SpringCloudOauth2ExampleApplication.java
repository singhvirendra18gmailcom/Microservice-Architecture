package com.javatechie.spring.cloud.security.api;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class SpringCloudOauth2ExampleApplication {
	
	@GetMapping("/")
	public String message(Principal principal) {
		OAuth2Authentication ap=(OAuth2Authentication)principal;
		return "Hi "+ap.getOAuth2Request().getClientId()+" welcome to SpringCloudOauth2ExampleApplication";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOauth2ExampleApplication.class, args);
	}

}
