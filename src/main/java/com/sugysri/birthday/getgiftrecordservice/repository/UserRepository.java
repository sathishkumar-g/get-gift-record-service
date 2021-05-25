package com.sugysri.birthday.getgiftrecordservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sugysri.birthday.getgiftrecordservice.models.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {
	public UserDetails findByUserNameAndPassword(String userName, String password);
}
