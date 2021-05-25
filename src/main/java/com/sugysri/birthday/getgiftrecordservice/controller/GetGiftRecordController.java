package com.sugysri.birthday.getgiftrecordservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sugysri.birthday.getgiftrecordservice.models.GiftRecord;
import com.sugysri.birthday.getgiftrecordservice.service.GetGiftRecordService;

@RestController
//@RequestMapping("/giftRecord")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class GetGiftRecordController {
	@Autowired
	private GetGiftRecordService getGiftRecordService;

	@RequestMapping("/get")
	public GiftRecord getGiftRecord() {
		return getGiftRecordService.getGiftRecord();
	}

}
