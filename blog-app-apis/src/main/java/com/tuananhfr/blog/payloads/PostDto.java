package com.tuananhfr.blog.payloads;



import java.util.HashSet;
import java.util.Set;

import com.tuananhfr.blog.entities.Comment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PostDto {
	private Integer postId;
	@NotEmpty
	@Size(min = 4, message = "Title must be min of 4 characters !!")
	private String title;
	@NotEmpty
	private String content;

	private String imageName;

	private String addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto> comments = new HashSet<>();
	

}
