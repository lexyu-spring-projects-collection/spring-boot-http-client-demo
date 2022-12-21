package com.lex.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lex.practice.model.Post;
import com.lex.practice.model.PostComment;
import com.lex.practice.service.PostService;

@RestController
@RequestMapping("/test/v1")
public class CallExternalController {
	
	private final PostService postService;
	
	@Autowired
	public CallExternalController(PostService postService) {
		this.postService = postService;
	}

	/*
	@GetMapping(value = "/posts")
	public String getUserPosts() {
		return postService.fetchPostsInfo();
	}
	*/
	
	
	@GetMapping("/posts")
	public Post[] getAllUsersAllPosts() {
		return postService.fetchAllUsersAllPostsInfo();
	}
	
	
	@GetMapping("/posts/users/{userId}")
	public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable("userId") int id) {
		List<Post> postList = postService.fetchAllPostsByUserId(id);
	
		return ResponseEntity.ok(postList);
	}
	
	@GetMapping("/posts/comments/{postId}")
	public ResponseEntity<List<PostComment>> getAllCommentsFromPost(@PathVariable("postId") int id) {
		List<PostComment> comments = postService.fetchAllCommentsFromPost(id);
	
		return ResponseEntity.ok(comments);
	}
	
	@PostMapping("/posts")
	public ResponseEntity<Post> createPost(@RequestBody Post postModel) {
		postModel = postService.createPost(postModel);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(postModel);
	}
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> updatePost(@RequestBody Post postModel, @PathVariable("id") int id) {
		postModel = postService.updatePost(postModel, id);
		
		return ResponseEntity.ok(postModel);
	}
	
	
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<Post> deletePost(@PathVariable("id") int id) {
		postService.deletePost(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}