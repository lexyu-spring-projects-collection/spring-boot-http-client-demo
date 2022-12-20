package com.lex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lex.practice.output.PostDetails;
import com.lex.practice.service.PostService;

@RestController
@RequestMapping("/test")
public class PostController {
	
	private PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping(value = "/byId/{id}",
			consumes = MediaType.ALL_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PostDetails getPosts(@PathVariable("id") String id) {
		
		if (id == null || "".equals(id)) {
			id = "";
		}
		PostDetails p = postService.fetchAllPostsInfo(id);
		
		return p;
	}

}