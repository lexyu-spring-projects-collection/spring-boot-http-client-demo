package com.lex.practice.serviceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrganiztionServiceImpl {
	
	@Value("${get.orglist.url}")
	private String getOrgListUsr;
	
}
