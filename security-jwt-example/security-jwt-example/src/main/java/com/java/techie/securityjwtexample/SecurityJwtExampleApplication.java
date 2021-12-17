package com.java.techie.securityjwtexample;

import com.java.techie.securityjwtexample.entity.User;
import com.java.techie.securityjwtexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SecurityJwtExampleApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initUser(){
		List<User> userList = Stream.of(
				new User(101, "user1", "pwd1", "user1@gmail.com"),
				new User(102, "user2", "pwd2", "user2@gmail.com"),
				new User(103, "user3", "pwd3", "user3@gmail.com"))
				.collect(Collectors.toList());
		userRepository.saveAll(userList);
	}

	public static void main(String[] args) {
		SpringApplication.run(SecurityJwtExampleApplication.class, args);
	}

}
