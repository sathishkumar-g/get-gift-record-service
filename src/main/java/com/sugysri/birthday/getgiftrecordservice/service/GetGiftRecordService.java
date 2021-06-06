package com.sugysri.birthday.getgiftrecordservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sugysri.birthday.getgiftrecordservice.models.Constants;
import com.sugysri.birthday.getgiftrecordservice.models.GiftRecord;
import com.sugysri.birthday.getgiftrecordservice.models.GiftRecordItem;
import com.sugysri.birthday.getgiftrecordservice.repository.GiftRecordRepository;

@Service
public class GetGiftRecordService {

	@Autowired
	private GiftRecordRepository giftRecordRepository;

	@Autowired
	private CacheManager cacheManager;
	
	@Autowired
	private GiftRecord giftRecord;

	@Cacheable(value = Constants.GIFT_RECORD_CACHE)
	public GiftRecord getGiftRecord() {
		List<GiftRecordItem> giftRecords = null;
		giftRecords = giftRecordRepository.findAll();
		giftRecords.forEach(record -> addToCache(record));
		giftRecord.setGiftRecords(giftRecords);
		return giftRecord;
	}

	@CachePut(value = Constants.GIFT_RECORD_ITEMS_CACHE, key = "#giftRecordItem.s_no")
	public GiftRecordItem editGiftRecord(GiftRecordItem giftRecordItem) {
		return giftRecordRepository.saveAndFlush(giftRecordItem);
	}

	@CacheEvict(value = Constants.GIFT_RECORD_ITEMS_CACHE, key = "#giftRecordItem.s_no")
	public void deleteGiftRecord(GiftRecordItem giftRecordItem) {
		giftRecordRepository.delete(giftRecordItem);
		giftRecordRepository.flush();
	}

	@CachePut(value = Constants.GIFT_RECORD_ITEMS_CACHE, key = "#result.s_no")
	public GiftRecordItem addGiftRecord(GiftRecordItem giftRecordItem) {
		return giftRecordRepository.saveAndFlush(giftRecordItem);
	}

	public void deleteGiftRecords(List<GiftRecordItem> giftRecords) {
		giftRecordRepository.deleteAll(giftRecords);
		giftRecordRepository.flush();
		giftRecords.forEach(record -> removeFromCache(record));
	}

	public void addToCache(GiftRecordItem giftRecordItem) {
		Cache cache = cacheManager.getCache(Constants.GIFT_RECORD_ITEMS_CACHE);
		cache.putIfAbsent(giftRecordItem.getSerialNumber(), giftRecordItem);
	}

	public void removeFromCache(GiftRecordItem giftRecordItem) {
		Cache cache = cacheManager.getCache(Constants.GIFT_RECORD_ITEMS_CACHE);
		cache.evictIfPresent(giftRecordItem.getSerialNumber());
	}

}
