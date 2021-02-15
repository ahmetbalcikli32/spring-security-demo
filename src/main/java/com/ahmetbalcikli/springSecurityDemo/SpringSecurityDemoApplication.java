package com.ahmetbalcikli.springSecurityDemo;

import com.ahmetbalcikli.springSecurityDemo.user.entity.Role;
import com.ahmetbalcikli.springSecurityDemo.user.entity.User;
import com.ahmetbalcikli.springSecurityDemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringSecurityDemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
		ApplicationCommandLineRunner runner = new ApplicationCommandLineRunner();
		runner.run();
	}

}

@Component
class ApplicationCommandLineRunner implements CommandLineRunner{

	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("test");
		user.setEnabled(true);
		user.setRole(Role.ADMIN);

		User userAhmet = new User();
		user.setUsername("ahmet");
		user.setPassword("test");
		user.setEnabled(true);
		user.setRole(Role.ADMIN);

		User userMerve = new User();
		user.setUsername("merve");
		user.setPassword("test");
		user.setEnabled(true);
		user.setRole(Role.USER);

		userService.createUser(user);
		userService.createUser(userAhmet);
		userService.createUser(userMerve);
	}
}
