package com.sugysri.birthday.getgiftrecordservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sugysri.birthday.getgiftrecordservice.models.UserDetails;
import com.sugysri.birthday.getgiftrecordservice.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private CacheManager cacheManager;

	@Cacheable(value = "userDetailsCache", key = "#userDetails.id", unless = "#result=null")
	public UserDetails getUserRecord(UserDetails userDetails) {
		return userRepository.findByUserNameAndPassword(userDetails.getUserName(), userDetails.getPassword());
	}

	public List<UserDetails> getAllUsers() {
		List<UserDetails> users = userRepository.findAll();
		users.forEach(record -> addToCache(record));
		return users;
	}

	public void addToCache(UserDetails userDetails) {
		Cache cache = cacheManager.getCache("userDetailsCache");
		cache.putIfAbsent(userDetails.getId(), userDetails);
	}

}
