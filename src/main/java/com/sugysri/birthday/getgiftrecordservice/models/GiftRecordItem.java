package com.sugysri.birthday.getgiftrecordservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "sugysri_gift_records")
public class GiftRecordItem {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gift_id_generator")
	@SequenceGenerator(name = "gift_id_generator", sequenceName = "gift_record_sequence", allocationSize = 1, initialValue = 100)
	private int s_no;
	@Column(name = "name")
	private String name;
	@Column(name = "area")
	private String area;
	@Column(name = "city")
	private String city;
	@Column(name = "job")
	private String job;
	@Column(name = "amount")
	private int amount;
	@Column(name = "gift")
	private String gift;
	@Column(name = "gold")
	private String gold;

	/**
	 * @return the serialNumber
	 */
	public int getSerialNumber() {
		return s_no;
	}

	/**
	 * @param serialNumber the serialNumber to set
	 */
	public void setSerialNumber(int s_no) {
		this.s_no = s_no;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the gift
	 */
	public String getGift() {
		return gift;
	}

	/**
	 * @param gift the gift to set
	 */
	public void setGift(String gift) {
		this.gift = gift;
	}

	/**
	 * @return the gold
	 */
	public String getGold() {
		return gold;
	}

	/**
	 * @param gold the gold to set
	 */
	public void setGold(String gold) {
		this.gold = gold;
	}

	public GiftRecordItem(int s_no, String name, String area, String city, String job, int amount, String gift,
			String gold) {
		super();
		this.s_no = s_no;
		this.name = name;
		this.area = area;
		this.city = city;
		this.job = job;
		this.amount = amount;
		this.gift = gift;
		this.gold = gold;
	}

	public GiftRecordItem() {

	}
}
