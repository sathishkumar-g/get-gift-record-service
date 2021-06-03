package com.sugysri.birthday.getgiftrecordservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sugysri.birthday.getgiftrecordservice.models.GiftRecord;
import com.sugysri.birthday.getgiftrecordservice.models.GiftRecordItem;
import com.sugysri.birthday.getgiftrecordservice.service.GetGiftRecordService;

@RestController
@RequestMapping("/gift")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GetGiftRecordController {
	@Autowired
	private GetGiftRecordService getGiftRecordService;

	@EventListener(classes = { ApplicationStartedEvent.class })
	@RequestMapping("/get")
	public GiftRecord getGiftRecord() {
		return getGiftRecordService.getGiftRecord();
	}

	@PostMapping(path = "/edit", consumes = "application/json", produces = "application/json")
	public GiftRecordItem editGiftRecord(@RequestBody GiftRecordItem giftRecordItem) {
		return getGiftRecordService.editGiftRecord(giftRecordItem);
	}

	@PostMapping(path = "/delete", consumes = "application/json", produces = "application/json")
	public void deleteGiftRecord(@RequestBody GiftRecordItem giftRecordItem) {
		getGiftRecordService.deleteGiftRecord(giftRecordItem);
	}
	
	@PostMapping(path = "/selectiveDelete"
			+ "", consumes = "application/json", produces = "application/json")
	public void deleteGiftRecords(@RequestBody GiftRecord giftRecord) {
		getGiftRecordService.deleteGiftRecords(giftRecord.getGiftRecords());
	}

	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public GiftRecordItem addGiftRecord(@RequestBody GiftRecordItem giftRecordItem) {
		return getGiftRecordService.addGiftRecord(giftRecordItem);
	}

}
