package com.lex.practice.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lex.practice.model.Post;
import com.lex.practice.model.PostComment;
import com.lex.practice.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostServiceImpl implements PostService{
	
	@Value("${external.api.url}")
	private String fakeAPIBaseUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public List<Post> fetchAllPostsByUserId(int userId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Post> httpEntity = new HttpEntity<>(headers);
		
		ResponseEntity<Object[]> responseEntity = 
				restTemplate.exchange(fakeAPIBaseUrl + "/users/{userId}/posts", HttpMethod.GET, httpEntity, Object[].class, userId);
		
		List<Post> postList = new ArrayList<>();
		
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			postList = Arrays.stream(responseEntity.getBody())
					.map(object -> mapper.convertValue(object, Post.class))
					.collect(Collectors.toList());
		}
		
		return postList;	
	}

	@Override
	public Post[] fetchAllUsersAllPostsInfo() {
		Post[] result = restTemplate.getForObject(fakeAPIBaseUrl + "/posts", Post[].class);
		return result;
	}


	@Override
	public Post createPost(Post postModel) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Post> httpEntity = new HttpEntity<>(postModel, headers);
		
		ResponseEntity<Post> responseEntity = 
				restTemplate.postForEntity(fakeAPIBaseUrl + "/posts", httpEntity, Post.class);
		log.info("ResponseEntity : {}", responseEntity.getHeaders());
		log.info("ResponseEntity : {}", responseEntity.getBody());
		log.info("ResponseEntity : {}", responseEntity.getStatusCode());
		if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
			postModel = responseEntity.getBody();
		}
		return postModel;
	}


	@Override
	public Post updatePost(Post postModel, int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Post> httpEntity = new HttpEntity<>(postModel, headers);
		
		ResponseEntity<Post> responseEntity = 
				restTemplate.exchange(fakeAPIBaseUrl + "/posts/{id}", HttpMethod.PUT, httpEntity, Post.class, id);
		log.info("ResponseEntity : {}", responseEntity.getHeaders());
		log.info("ResponseEntity : {}", responseEntity.getBody());
		log.info("ResponseEntity : {}", responseEntity.getStatusCode());
		
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			postModel = responseEntity.getBody();
		}
		return postModel;	
	}


	@Override
	public void deletePost(int id) {
		restTemplate.delete(fakeAPIBaseUrl + "/posts/{id}", id);
	}

	@Override
	public List<PostComment> fetchAllCommentsFromPost(int postId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<PostComment> httpEntity = new HttpEntity<>(headers);
		
		ResponseEntity<Object[]> responseEntity = 
				restTemplate.exchange(fakeAPIBaseUrl + "/posts/{postId}/comments", HttpMethod.GET, httpEntity, Object[].class, postId);
		
		List<PostComment> comments = new ArrayList<>();
		
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			comments = Arrays.stream(responseEntity.getBody())
					.map(object -> mapper.convertValue(object, PostComment.class))
					.collect(Collectors.toList());
		}
		
		return comments;	
	}

	/*
	@Override
	public String fetchPostsInfo() {
		return restTemplate.getForObject(fakeAPIBaseUrl + "/posts", String.class);
	}
	*/
	

}
