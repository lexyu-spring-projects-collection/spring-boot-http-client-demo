package com.lex.practice.serviceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl {

	@Value("${exchange.profile.url}")
	private String exchangeProfileUrl;
	
}
