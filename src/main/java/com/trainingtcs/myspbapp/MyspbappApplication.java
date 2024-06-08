package com.trainingtcs.myspbapp;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication

public class MyspbappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspbappApplication.class, args);
	}

}
