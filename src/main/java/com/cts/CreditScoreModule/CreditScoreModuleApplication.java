package com.cts.CreditScoreModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CreditScoreModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditScoreModuleApplication.class, args);
	}

}
