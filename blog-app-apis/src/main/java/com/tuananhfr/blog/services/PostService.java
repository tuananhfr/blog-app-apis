package com.tuananhfr.blog.services;

import java.util.List;

import com.tuananhfr.blog.payloads.PostDto;
import com.tuananhfr.blog.payloads.PostResponse;

public interface PostService {
	
	// create
	PostDto createPost(PostDto postDto,Integer userId,Integer postId);
	
	//update
	PostDto updatePost(PostDto postDto, Integer categoryId);
	
	// get a post
	PostDto getPostById(Integer postId);
	
	// get all posts
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	// get all post by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// get all post by user
	List<PostDto> getPostsByUser(Integer userId);
		
	// search posts
	List<PostDto> searchPosts(String keyword);
		
	// delete a post
	void deletePost(Integer postId);
}
