package com.skillkart;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.skillkart.entity.Role;
import com.skillkart.entity.User;
import com.skillkart.service.UserService;

@SpringBootApplication
public class SkillkartserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SkillkartserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("starting code");

		User u1 = new User();

		u1.setFirstName("Aman");
		u1.setLastName("Bansiwal");
		u1.setEmail("aman@gmail.com");
		u1.setPassword("9414944929");
		u1.setUsername("krysje");

		Role role1 = new Role();
		role1.setName("ADMIN");	
		 
		Set<Role> set = new HashSet<>(); 
		set.add(role1);
		
		 
//		user.getRoles().add(role1);
//		role1.getUsers().add(user);
		

		User local =  this.userService.createUser(u1, set);
		
		System.out.println(local.getUsername());

	}

}
