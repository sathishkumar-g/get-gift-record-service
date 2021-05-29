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
		giftRecords = giftRecordRepository.findAll();
		giftRecord = new GiftRecord(giftRecords);
		return giftRecord;
	}

	public GiftRecordItem editGiftRecord(GiftRecordItem giftRecordItem) {
		return giftRecordRepository.saveAndFlush(giftRecordItem);
	}

	public void deleteGiftRecord(GiftRecordItem giftRecordItem) {
		giftRecordRepository.delete(giftRecordItem);
		giftRecordRepository.flush();
	}

	public GiftRecordItem addGiftRecord(GiftRecordItem giftRecordItem) {
		return giftRecordRepository.saveAndFlush(giftRecordItem);
	}

	public void deleteGiftRecords(List<GiftRecordItem> giftRecords) {
		giftRecordRepository.deleteAll(giftRecords);
		giftRecordRepository.flush();
	}

}
