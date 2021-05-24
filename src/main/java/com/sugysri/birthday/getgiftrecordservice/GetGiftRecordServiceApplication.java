package com.sugysri.birthday.getgiftrecordservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GetGiftRecordServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetGiftRecordServiceApplication.class, args);
	}

}
