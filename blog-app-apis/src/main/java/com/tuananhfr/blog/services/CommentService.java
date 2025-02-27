package com.tuananhfr.blog.services;

import java.util.List;

import com.tuananhfr.blog.payloads.CommentDto;

public interface CommentService {
	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	void deleteComment(Integer commentId);
}
