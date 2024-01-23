package com.lex.caller.controller;

import com.lex.caller.dto.TestDto;
import com.lex.caller.model.Student;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/student")
public class StudentCallerController {
	@GetMapping
	public ResponseEntity<Student> getStudentsInfo(){
		
		Student s1 = new Student();
		s1.setStudentId(1);
		s1.setStudentName("Test Student");
		s1.setAddress("Test Student Address");
//		s1.setCollegeData(); // call restTemplate or WebClient

		String url = "http://localhost:9002/college";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<TestDto> httpEntity = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<TestDto> responseEntity =
				restTemplate.exchange(url, HttpMethod.GET, httpEntity, TestDto.class);
		TestDto testDto = responseEntity.getBody();
		s1.setTestDtoData(testDto);
		testDto.getStrList().stream().forEach(System.out::println);
		
		return new ResponseEntity<Student>(s1, HttpStatus.OK);
	}
}
