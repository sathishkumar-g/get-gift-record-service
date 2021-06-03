package com.sugysri.birthday.getgiftrecordservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.sugysri.birthday.getgiftrecordservice.models.GiftRecord;

@SpringBootApplication
//@EnableEurekaClient
@EnableCaching
public class GetGiftRecordServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetGiftRecordServiceApplication.class, args);
	}
	
	@Bean
	GiftRecord giftRecord() {
		return new GiftRecord();
	}
	
}
