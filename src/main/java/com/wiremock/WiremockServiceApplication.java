package com.wiremock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WiremockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WiremockServiceApplication.class, args);
	}

}
