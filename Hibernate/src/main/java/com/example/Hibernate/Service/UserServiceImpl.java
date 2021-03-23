package com.example.Hibernate.Service;

import com.example.Hibernate.Pojo.User;
import com.example.Hibernate.Thymeleaf.dto.UserDto;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceImpl extends UserDetailsService {

	public void save(UserDto userDto);
	public Optional<User> findById(long id);
	public void delete(User user);
}
