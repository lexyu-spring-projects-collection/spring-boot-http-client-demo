package com.lex.practice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile {
	
	
	@JsonProperty("uuid")
	private Long uuid;
	@JsonProperty("nickname")
	private String nickname;
	@JsonProperty("email")
	private String email;
	@JsonProperty("client_id")
	private String clientId;
	@JsonProperty("roles")
	private List<String> roles;
	@JsonProperty("permissions")
	private List<String> permissions;

	/*
	active
	auth_type
	client_id
	create_at
	email
	email_verified
	login_type
	nickname
	picture
	policies(Array)
	roles(Array)
	uuid
	 */
	
	
}
