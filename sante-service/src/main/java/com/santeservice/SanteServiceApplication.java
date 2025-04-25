package com.santeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.santeservice.feign")
@SpringBootApplication
public class SanteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanteServiceApplication.class, args);
	}

}
