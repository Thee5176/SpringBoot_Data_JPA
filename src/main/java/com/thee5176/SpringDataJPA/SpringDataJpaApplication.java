package com.thee5176.SpringDataJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableJpaRepositories("com.thee5176.SpringDataJPA.Repository")
@EntityScan("com.thee5176.SpringDataJPA.Entity")
@SpringBootApplication
public class SpringDataJpaApplication {
	
	@GetMapping("/health-check")
	public String getHealthCheck() {
		return "Status Normal All Fired Up";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
