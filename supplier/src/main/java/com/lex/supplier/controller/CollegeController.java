package com.lex.supplier.controller;

import com.lex.supplier.dto.TestDto;
import com.lex.supplier.model.College;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CollegeController {

	@GetMapping("/college")
	public ResponseEntity<TestDto> getCollegesInfo() throws InterruptedException {
		List<String> OrgNames = new ArrayList<>();
		OrgNames.add("test1");
		OrgNames.add("test2");
		OrgNames.add("test3");
		OrgNames.add("test4");
		OrgNames.add("test5");
		
		TestDto testDto = new TestDto();
		testDto.setStrList(OrgNames);

		Thread.sleep(2000L);

		System.out.println("Thread = " + Thread.currentThread().getName() + ", Resp = " + testDto);


		return ResponseEntity.ok(testDto);
	}
}
