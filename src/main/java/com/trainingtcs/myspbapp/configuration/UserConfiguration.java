package com.trainingtcs.myspbapp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class UserConfiguration {

	@Value("${hrpaymentsservice.base.url}")
	private String hrPaymentsBaseUrl;

	@Bean
	public ModelMapper modelMapperBean(){
		return new ModelMapper();
	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder().baseUrl(hrPaymentsBaseUrl).build();
	}
}
