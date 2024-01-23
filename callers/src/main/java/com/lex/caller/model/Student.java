package com.lex.caller.model;

import com.lex.caller.dto.TestDto;
import lombok.Data;

@Data
public class Student {
	
	private int studentId;
	private String studentName;
	private String address;
	private College collegeData;
	private TestDto testDtoData;

}
