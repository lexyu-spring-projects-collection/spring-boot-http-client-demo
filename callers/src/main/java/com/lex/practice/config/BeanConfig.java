package com.lex.practice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;


@Configuration
public class BeanConfig {
	
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
        		.setConnectTimeout(Duration.ofSeconds(60))
        		.setReadTimeout(Duration.ofSeconds(180))
        		.build();
    }

	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}

	@Bean("local")
	public WebClient webClientCallLocal(){
		return WebClient.builder().baseUrl("http://localhost:8080/api").build();
	}


	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}

}
