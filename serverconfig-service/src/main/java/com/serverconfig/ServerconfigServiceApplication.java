package com.serverconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ServerconfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerconfigServiceApplication.class, args);
	}

}
