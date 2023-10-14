package com.lex.supplier.controller.unsorted_old_code;

import com.lex.supplier.dto.TestDto;
import com.lex.supplier.model.College;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {

	
	@GetMapping
	public ResponseEntity<TestDto> getCollegesInfo(){
		
		College c1 = new College();
		c1.setCollegeId(1);
		c1.setCollegeName("Test College");
		c1.setAddress("Test College Address");
		
		List<String> OrgNames = new ArrayList<>();
		OrgNames.add("test1");
		OrgNames.add("test2");
		OrgNames.add("test3");
		OrgNames.add("test4");
		OrgNames.add("test5");
		
		TestDto testDto = new TestDto();
		testDto.setStrList(OrgNames);
		
		return ResponseEntity.ok(testDto);
	}
}
