package com.lex.practice.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
public class BeanConfig {
	
	@Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
	
	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}

}
