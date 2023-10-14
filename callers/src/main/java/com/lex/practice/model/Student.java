package com.lex.practice.model;

import com.lex.practice.dto.TestDto;
import lombok.Data;

@Data
public class Student {
	
	private int studentId;
	private String studentName;
	private String address;
	private College collegeData;
	private TestDto testDtoData;

}
