package com.sugysri.birthday.getgiftrecordservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sugysri.birthday.getgiftrecordservice.models.UserDetails;
import com.sugysri.birthday.getgiftrecordservice.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	@Cacheable(value = "userDetailsCache")
	public UserDetails getUserRecord(UserDetails userDetails) {
		return userRepository.findByUserNameAndPassword(userDetails.getUserName(), userDetails.getPassword());
	}

}
