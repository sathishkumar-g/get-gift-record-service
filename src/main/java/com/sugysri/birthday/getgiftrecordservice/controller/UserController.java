package com.sugysri.birthday.getgiftrecordservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sugysri.birthday.getgiftrecordservice.models.UserDetails;
import com.sugysri.birthday.getgiftrecordservice.service.UserService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/authenticate", consumes = "application/json", produces = "application/json")
	public UserDetails getuserRecord(@RequestBody UserDetails userDetails) {
		return userService.getUserRecord(userDetails);
	}
}
