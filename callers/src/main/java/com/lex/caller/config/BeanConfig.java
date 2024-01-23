package com.lex.caller.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lex.caller.service.ArticleClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

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
	ArticleClient articleClient() {
		WebClient client = WebClient.builder()
				.baseUrl("http://localhost:9999/api")
				.build();

		WebClientAdapter adapter = WebClientAdapter.create(client);
		adapter.setBlockTimeout(Duration.ofSeconds(5));

		HttpServiceProxyFactory factory = HttpServiceProxyFactory
				.builderFor(adapter)
				.build();

		return factory.createClient(ArticleClient.class);
	}

	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}

}
