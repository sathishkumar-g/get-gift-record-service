package com.sugysri.birthday.getgiftrecordservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sugysri.birthday.getgiftrecordservice.models.GiftRecord;
import com.sugysri.birthday.getgiftrecordservice.models.GiftRecordItem;
import com.sugysri.birthday.getgiftrecordservice.repository.GiftRecordRepository;

@Service
public class GetGiftRecordService {

	@Autowired
	private GiftRecordRepository giftRecordRepository;

	public GiftRecord getGiftRecord() {
		GiftRecord giftRecord = null;
		List<GiftRecordItem> giftRecords = null;
		/*
		 * giftRecord = new GiftRecord(new ArrayList<GiftRecordItem>( Arrays.asList(new
		 * GiftRecordItem(1,"sathish","varakalpet","cuddalore","software",1000,"toys",
		 * "na"))));
		 */
		giftRecords = giftRecordRepository.findAll();
		giftRecord = new GiftRecord(giftRecords);
		return giftRecord;
	}

	/*
	 * public GiftRecord addGiftRecord() {
	 * 
	 * }
	 * 
	 * public GiftRecord editGiftRecord() {
	 * 
	 * }
	 * 
	 * public GiftRecord deleteGiftRecord() {
	 * 
	 * }
	 */

}
