package com.udacity.pricing.PriceMicroservice;

import com.udacity.pricing.PriceMicroservice.entity.Price;
import com.udacity.pricing.PriceMicroservice.repository.PriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class PriceMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceMicroserviceApplication.class, args);
	}

}
