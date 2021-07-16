package com.project.stockexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.project.stockexchangeservice.repository.StockExchangeRepository;

@SpringBootApplication
public class StockExchangeServiceApplication {

	public static void main(String[] args) {	
		SpringApplication.run(StockExchangeServiceApplication.class, args);
	}

}
