package com.example.firstRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication	
//@ComponentScan("com.example.*")
@ComponentScan({"com.example.controller","com.example.service","com.example.aop","com.example.schedular"})
@EntityScan({"com.example.entity"})
@EnableJpaRepositories("com.example.repository")
@EnableScheduling
public class firstRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(firstRestApiApplication.class, args);
	}

}
