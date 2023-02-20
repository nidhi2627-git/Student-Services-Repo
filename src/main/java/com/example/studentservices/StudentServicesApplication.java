package com.example.studentservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentServicesApplication {

	public static void main(String[] args) {

		try{
			SpringApplication.run(StudentServicesApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}