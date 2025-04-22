package com.techservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TechServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechServiceApplication.class, args);
	}

}
