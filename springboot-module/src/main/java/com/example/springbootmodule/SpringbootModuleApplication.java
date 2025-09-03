package com.example.springbootmodule;

import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

@AutoConfiguration
@SpringBootApplication
public class SpringbootModuleApplication implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;


	public static void main(String[] args) {
		SpringApplication.run(SpringbootModuleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(dataSource);
	}
}
