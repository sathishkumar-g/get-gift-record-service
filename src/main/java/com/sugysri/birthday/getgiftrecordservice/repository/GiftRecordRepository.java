package com.sugysri.birthday.getgiftrecordservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sugysri.birthday.getgiftrecordservice.models.GiftRecordItem;

public interface GiftRecordRepository extends JpaRepository<GiftRecordItem, Integer>{
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	@Override
	List<GiftRecordItem> findAll();

}
