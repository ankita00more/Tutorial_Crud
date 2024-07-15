package com.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.blog.controller")
@ComponentScan("com.blog.model")
@ComponentScan("com.blog.service")
@ComponentScan("com.blog.repository")
public class SpringDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDbApplication.class, args);
		System.out.println("Hello");
	}

}
