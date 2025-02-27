package com.tuananhfr.blog.respositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.tuananhfr.blog.entities.Comment;


public interface CommentRepo extends JpaRepository<Comment,Integer> {


}
