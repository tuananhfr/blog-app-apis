package com.tuananhfr.blog.services;

import java.util.List;
import com.tuananhfr.blog.payloads.UserDto;
public interface UserService {
	
	UserDto registerNewUser(UserDto userDto);
	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto userDto, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
	
}
