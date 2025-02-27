package com.tuananhfr.blog.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuananhfr.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}
