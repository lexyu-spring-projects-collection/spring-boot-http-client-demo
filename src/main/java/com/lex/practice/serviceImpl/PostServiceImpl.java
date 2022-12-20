package com.lex.practice.serviceImpl;


import java.util.Collections;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lex.practice.output.PostDetails;
import com.lex.practice.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public PostDetails fetchAllPostsInfo(String id) {
		
		String url = "https://jsonplaceholder.typicode.com/posts/{id}";
		url = url.replace("{id}", id);
		log.info("url={}", url);
		
		HttpHeaders headers = new HttpHeaders();
//	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));        
		headers.setContentType(MediaType.APPLICATION_JSON);
//		headers.add(HttpHeaders.AUTHORIZATION, "Bearer Token");
		headers.setBearerAuth("Token");
		log.info("Headers = {}", headers);
		
//		ResponseEntity<PostDetails> postResponseEntity = restTemplate.getForEntity(url, PostDetails.class);
		ResponseEntity<PostDetails> postResponseEntity = 
				restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), PostDetails.class);
		log.info("postResponseEntity Headers : {}", postResponseEntity.getHeaders());
		log.info("postResponseEntity Body : {}", postResponseEntity.getBody());
		log.info("postResponseEntity Class : {}", postResponseEntity.getClass());
		log.info("Status : {}", postResponseEntity.getStatusCode());
		
		PostDetails responseArray = postResponseEntity.getBody();
		log.info("Response Array = {}", responseArray);
		
		return responseArray;
	}

}
