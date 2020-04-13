package com.testfan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.testfan.dao")
public class SpringbootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTestApplication.class, args);
	}
}
