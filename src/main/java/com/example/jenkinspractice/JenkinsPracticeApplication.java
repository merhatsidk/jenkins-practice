package com.example.jenkinspractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RequestMapping
@RestController
public class JenkinsPracticeApplication {

	@GetMapping("/")
	public  String hello(){
		return "Welcome to Jenkins pipeline !!";
	}


	public static void main(String[] args) {
		SpringApplication.run(JenkinsPracticeApplication.class, args);
	}

}
