package com.tuananhfr.blog.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuananhfr.blog.entities.Category;
import com.tuananhfr.blog.entities.Post;
import com.tuananhfr.blog.entities.User;

public interface PostRepo extends JpaRepository<Post,Integer> {

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);
}
