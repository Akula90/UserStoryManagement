package com.user.UserStoryManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class UserStoryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserStoryManagementApplication.class, args);
	}

}
