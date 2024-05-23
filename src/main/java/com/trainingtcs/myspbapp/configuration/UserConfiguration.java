package com.trainingtcs.myspbapp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.trainingtcs.myspbapp.service.UserService;
import org.springframework.stereotype.Component;

@Configuration
public class UserConfiguration {
	@Bean
	public ModelMapper modelMapperBean(){
		return new ModelMapper();
	}
}
