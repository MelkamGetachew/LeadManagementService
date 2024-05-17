package com.craft.leadmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.craft"})
@EntityScan("com.craft.model")
public class LeadManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadManagementServiceApplication.class, args);
	}

}
