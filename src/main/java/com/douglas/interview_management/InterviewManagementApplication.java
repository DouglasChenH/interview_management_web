package com.douglas.interview_management;

import com.douglas.interview_management.models.User;
import com.douglas.interview_management.repository.UserRepository;
import com.douglas.interview_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterviewManagementApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(InterviewManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



		//fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("--------------------------------");
		for (User user : userService.findAll()) {
			System.out.println(user);
		}
		System.out.println();




	}
}
