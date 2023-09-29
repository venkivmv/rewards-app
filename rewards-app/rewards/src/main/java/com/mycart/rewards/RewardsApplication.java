package com.mycart.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EntityScan(basePackages = { "com.mycart.rewards.entity" })
@EnableJpaRepositories(basePackages = { "com.mycart.rewards.repository" })
@EnableTransactionManagement
public class RewardsApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(RewardsApplication.class, args);
	
	}


}
