package com.tuananhfr.blog.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuananhfr.blog.services.CommentService;



import com.tuananhfr.blog.payloads.ApiResponse;
import com.tuananhfr.blog.payloads.CommentDto;
@RestController
@RequestMapping("/api/")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	// POST - create comment
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createUser(@RequestBody CommentDto commentDto, @PathVariable Integer postId) {
		CommentDto createCommentDto = this.commentService.createComment(commentDto,postId);
		return new ResponseEntity<CommentDto>(createCommentDto,HttpStatus.CREATED);
	}
	
	// DELETE - delete comment
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer commentId) {
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment Deleted Successfully",true),HttpStatus.OK);
	}
}
