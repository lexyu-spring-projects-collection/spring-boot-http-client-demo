package com.lex.practice.service;

import java.util.List;

import com.lex.practice.model.Post;

public interface PostService {
	
//	PostModel fetchPostsInfo();
	Post[] fetchAllUsersAllPostsInfo();
	
	List<Post> fetchAllPostsByUserId(int userId);
		
	Post createPost(Post postModel);
	
	Post updatePost(Post postModel, int id);

	void deletePost(int id);

}
