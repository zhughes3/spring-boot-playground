package com.example.springbootplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootPlaygroundApplication {
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		//turn this into a service discovery endpoint
		return "Hello World!";
	}

	public static void main(String[] args) {
		System.out.println("Working Directory =" + System.getProperty("user.dir"));
		SpringApplication.run(SpringBootPlaygroundApplication.class, args);
	}
}
