package com.trainingtcs.myspbapp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.trainingtcs.myspbapp.service.UserService;

@Configuration
public class UserConfiguration {
	@Bean
	public UserService userBean() {
		return new UserService();
	}
	
	@Bean
	public ModelMapper modelMapperBean(){
		return new ModelMapper();
		
	}
}
