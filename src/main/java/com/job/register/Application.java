package com.job.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.setProperty("LOG_PATH", "D://test");
		SpringApplication.run(Application.class, args);

	}

}
