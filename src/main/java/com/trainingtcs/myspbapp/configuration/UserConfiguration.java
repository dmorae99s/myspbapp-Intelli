package com.trainingtcs.myspbapp.configuration;

import com.netflix.discovery.EurekaClient;
import io.github.resilience4j.common.timelimiter.configuration.TimeLimiterConfigCustomizer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class UserConfiguration {

	@Bean
	public ModelMapper modelMapperBean(){
		return new ModelMapper();
	}

}
