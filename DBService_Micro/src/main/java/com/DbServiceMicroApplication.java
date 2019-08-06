package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages= "com.repository")
public class DbServiceMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbServiceMicroApplication.class, args);
	}

}
