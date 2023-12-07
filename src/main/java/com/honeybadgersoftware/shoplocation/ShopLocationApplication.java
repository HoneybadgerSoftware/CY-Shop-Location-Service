package com.honeybadgersoftware.shoplocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients
@EnableJpaRepositories
@SpringBootApplication
public class ShopLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopLocationApplication.class, args);
	}

}
