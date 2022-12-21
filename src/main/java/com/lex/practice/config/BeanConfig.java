package com.lex.practice.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
public class BeanConfig {
	
	@Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
        		.setConnectTimeout(Duration.ofSeconds(60))
        		.setReadTimeout(Duration.ofSeconds(180))
        		.build();
    }
	
	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}

}
