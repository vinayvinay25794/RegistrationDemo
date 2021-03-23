package com.example.Hibernate.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Hibernate.Dao.UserDao;
import com.example.Hibernate.Pojo.Role;
import com.example.Hibernate.Pojo.User;
import com.example.Hibernate.Thymeleaf.dto.UserDto;



@Service
public class UserService implements UserServiceImpl{

	@Autowired
	private UserDao dao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public void save(UserDto userDto) {
		User user = new User(userDto.getFirstName(),userDto.getLastName(),
				userDto.getEmailId(),userDto.getPhone(), passwordEncoder.encode(userDto.getPassword()),
				Arrays.asList(new Role("user_role")));
		dao.save(user);
	}


	public List<User> findAll() {
	
		
		return dao.findAll();
		
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = dao.findByEmailId(username);
		System.out.println(user);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getrName())).collect(Collectors.toList());
	}


	@Override
	public Optional<User> findById(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}


	@Override
	public void delete(User user) {
		dao.delete(user);
		
	}

}
