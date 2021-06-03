package com.sugysri.birthday.getgiftrecordservice.models;

import java.io.Serializable;
import java.util.List;

public class GiftRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<GiftRecordItem> giftRecords;

	/**
	 * @return the giftRecords
	 */
	public List<GiftRecordItem> getGiftRecords() {
		return giftRecords;
	}

	/**
	 * @param giftRecords the giftRecords to set
	 */
	public void setGiftRecords(List<GiftRecordItem> giftRecords) {
		this.giftRecords = giftRecords;
	}

	public GiftRecord(List<GiftRecordItem> giftRecords) {
		super();
		this.giftRecords = giftRecords;
	}
	
	public GiftRecord() {
		
	}

}
