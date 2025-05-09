package com.javaacademy.demo;

import com.javaacademy.demo.Entity.Advert;
import com.javaacademy.demo.Entity.Booking;
import com.javaacademy.demo.Entity.Client;
import com.javaacademy.demo.repository.AdvertRepository;
import com.javaacademy.demo.repository.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class HouseRentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseRentApplication.class, args);
	}

}
