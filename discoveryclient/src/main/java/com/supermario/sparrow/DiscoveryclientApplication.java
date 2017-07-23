package com.supermario.sparrow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.supermario.sparrow.disclient.mapper")
public class DiscoveryclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryclientApplication.class, args);
	}
}
