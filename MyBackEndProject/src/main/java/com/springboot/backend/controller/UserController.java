package com.springboot.backend.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.UserInfoDTO;
import com.springboot.backend.model.Customer;
import com.springboot.backend.model.UserInfo;
import com.springboot.backend.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired(required=true)
	private PasswordEncoder passwordEncoder; 
	
	@PostMapping("/user")
	public UserInfo postUser(@RequestBody UserInfo user) {
		UserInfo info = userRepository.getByUsername(user.getUsername());
		if(info != null)
			throw new RuntimeException("Username Invalid!!!");
		
		String password = user.getPassword();
		password = passwordEncoder.encode(password);
		user.setPassword(password);
		return userRepository.save(user);
		
	}
	
	
	@GetMapping("/user") 
	public UserInfoDTO login(Principal principal) {
		String username = principal.getName();
		UserInfo info = userRepository.getByUsername(username);
		UserInfoDTO dto = new UserInfoDTO();
		dto.setId(info.getId());
		dto.setName(info.getName());
		dto.setUsername(info.getUsername());
		dto.setAccountType(info.getAccountType());
		return dto; 
	}
	
	@GetMapping("/login") 
	public List<UserInfo> getAllAccounts() {
		List<UserInfo> list = userRepository.findAll();
		return list;
	}
	
	
	
	
	
	
	
	
}