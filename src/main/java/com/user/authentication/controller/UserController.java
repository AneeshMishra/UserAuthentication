package com.user.authentication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.authentication.model.User;


@RestController
@RequestMapping({ "/users" })
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	private List<User> usersList = createList();
	
	@GetMapping
	public List<User> getAllUsers() {
		return this.usersList;
	}
	
	@PostMapping
	public User create(@RequestBody User user) {
		usersList.add(user);
		return user;
	}
	
	@GetMapping("/getUser")
	public List<User> getUserById(@RequestParam String id) {
		return usersList.stream().filter((u) -> u.getEmailId().equals(id)).collect(Collectors.toList());
			 
	}
	
	private List<User> createList(){
		List<User> temp = new ArrayList<User>();
		User u1 = new User();
		u1.setEmailId("aneesh.mishra@gmail.com");
		u1.setName("aneesh");
		u1.setPassword("mishra");
		u1.setId(100);
		User u2 = new User();
		u2.setEmailId("aneesh.mishra@gmail.com");
		u2.setName("aneesh");
		u2.setPassword("mishra");
		u2.setId(100);
		temp.add(u2);
		temp.add(u1);
		return temp;
	}
}
