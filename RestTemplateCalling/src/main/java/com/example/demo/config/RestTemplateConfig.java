package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.example.demo.rest.exception.handler.MyErrorHandler;

@Configuration
public class RestTemplateConfig {
	
	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new MyErrorHandler());
		return restTemplate;
	}

}
