package com.bankac.l.k.uygulama3;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})

@EnableMongoRepositories
public class Uygulama3Application {

	public static void main(String[] args) {
		SpringApplication.run(Uygulama3Application.class, args);
	}

}
