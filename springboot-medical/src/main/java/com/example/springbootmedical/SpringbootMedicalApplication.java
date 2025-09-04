package com.example.springbootmedical;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.springbootmedical")
@MapperScan(basePackages = "com.example.springbootmedical.Repository")
@SpringBootApplication
public class SpringbootMedicalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMedicalApplication.class, args);
	}

}
