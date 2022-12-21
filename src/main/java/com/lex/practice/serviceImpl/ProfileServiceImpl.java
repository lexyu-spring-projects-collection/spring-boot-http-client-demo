package com.lex.practice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lex.practice.model.Post;
import com.lex.practice.model.Profile;
import com.lex.practice.service.ProfileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProfileServiceImpl implements ProfileService {

	@Value("${exchange.profile.url}")
	private String exchangeProfileUrl;

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public Profile exchageProile(String accessToken) {
		Profile profile = new Profile();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
//		headers.setBearerAuth("accessToken");
		
		HttpEntity<Profile> httpEntity = new HttpEntity<>(profile, headers);
		
		ResponseEntity<Profile> responseEntity = 
				restTemplate.exchange(exchangeProfileUrl, HttpMethod.POST, httpEntity, Profile.class);
		
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			profile = responseEntity.getBody();
		}
		
		return profile;
	}
	
}
