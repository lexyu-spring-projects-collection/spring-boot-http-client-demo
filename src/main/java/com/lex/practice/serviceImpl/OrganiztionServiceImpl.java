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
import com.lex.practice.model.Organization;
import com.lex.practice.model.Profile;
import com.lex.practice.service.OrganiztionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrganiztionServiceImpl implements OrganiztionService{
	
	@Value("${get.orglist.url}")
	private String getOrgListUsr;

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public Organization getOrgList(String uid) {
		Organization orgs = new Organization();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
//		headers.setBearerAuth("accessToken");
		
		HttpEntity<Organization> httpEntity = new HttpEntity<>(orgs, headers);
		
		ResponseEntity<Organization> responseEntity = 
				restTemplate.exchange(getOrgListUsr, HttpMethod.POST, httpEntity, Organization.class);
		
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			orgs = responseEntity.getBody();
		}
		
		return orgs;
	}
}
