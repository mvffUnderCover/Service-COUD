package com.etudiants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DisiMockApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisiMockApiApplication.class, args);
	}

}
