package com.project.stockexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StockExchangeServiceApplication {

	public static void main(String[] args) {	
		SpringApplication.run(StockExchangeServiceApplication.class, args);
	}

}
