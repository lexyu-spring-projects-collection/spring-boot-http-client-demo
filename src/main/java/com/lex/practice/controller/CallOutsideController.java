package com.lex.practice.controller;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpHeaders.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lex.practice.model.Organization;
import com.lex.practice.model.Profile;
import com.lex.practice.service.OrganiztionService;
import com.lex.practice.service.ProfileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class CallOutsideController {
	
	@Autowired
	private ProfileService profileService;
	@Autowired
	private OrganiztionService organiztionService;
	
	@PostMapping("/exchageProfile")
	public Profile exchageProile(HttpServletRequest request) {
		String accessToken = request.getHeader(AUTHORIZATION);
		log.info("Bearer Token : {}", accessToken);
		
//		profileService.exchageProile(accessToken);
		
		return null;
	}
	
	@PostMapping("/getOrgList")
	public Organization getOrgList(HttpServletRequest requests) {
//		organiztionService.getOrgList(uid);
	
		return null;
	}

}
