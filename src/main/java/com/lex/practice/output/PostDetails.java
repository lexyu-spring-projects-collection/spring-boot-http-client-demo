package com.lex.practice.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDetails {
	
	@JsonProperty("userId")
	private int userId;
	@JsonProperty("id")
	private int id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("body")
	private String body;
	
	
	/*
	"userId":
    "id":
    "title":
    "body":* 
	 */

}
