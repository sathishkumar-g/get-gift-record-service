package com.sugysri.birthday.getgiftrecordservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sugysri.birthday.getgiftrecordservice.models.Constants;
import com.sugysri.birthday.getgiftrecordservice.models.UserDetails;
import com.sugysri.birthday.getgiftrecordservice.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	private CacheManager cacheManager;
	

	@Cacheable(value = Constants.USER_CACHE, key = "#userDetails.userName", unless = "#result=null")
	public UserDetails getUserRecord(UserDetails userDetails) {
		return userRepository.findByUserNameAndPassword(userDetails.getUserName(), userDetails.getPassword());
	}

	public List<UserDetails> getAllUsers() {
		List<UserDetails> users = userRepository.findAll();
		users.forEach(record -> addToCache(record));
		return users;
	}

	public void addToCache(UserDetails userDetails) {
		Cache cache = cacheManager.getCache(Constants.USER_CACHE);
		cache.putIfAbsent(userDetails.getUserName(), userDetails);
	}

	@CachePut(value = Constants.USER_CACHE, key = "#userDetails.userName")
	public UserDetails addUserRecord(UserDetails userDetails) {
		return userRepository.saveAndFlush(userDetails);
	}

	public UserDetails getUserRecord(String userName) {
		return (UserDetails) cacheManager.getCache(Constants.USER_CACHE).get(userName).get();
	}
	
}
