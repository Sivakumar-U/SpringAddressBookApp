package com.bridgelabz.springaddressbookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringAddressBookAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringAddressBookAppApplication.class, args);
		log.info("Address Book app started in {} environment..", context.getEnvironment().getProperty("environment"));
		log.info("Address Book DB user is {} ", context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
