package com.test.appointmentapp.soapservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.test.appointmentapp.soapservice")
public class SoapServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SoapServiceApplication.class, args);
	}
}