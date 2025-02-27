package com.tuananhfr.blog.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuananhfr.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
