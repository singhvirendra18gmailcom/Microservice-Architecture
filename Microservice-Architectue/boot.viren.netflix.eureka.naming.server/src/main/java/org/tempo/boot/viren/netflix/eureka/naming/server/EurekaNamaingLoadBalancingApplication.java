package org.tempo.boot.viren.netflix.eureka.naming.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaNamaingLoadBalancingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaNamaingLoadBalancingApplication.class, args);
	}
}
