package com.sugysri.birthday.getgiftrecordservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sugysri.birthday.getgiftrecordservice.models.GiftRecordItem;

public interface GiftRecordRepository extends JpaRepository<GiftRecordItem, Integer>{
	
	

}
