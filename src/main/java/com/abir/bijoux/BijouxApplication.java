package com.abir.bijoux;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.abir.bijoux.entities.Bijoux;
import com.abir.bijoux.entities.Role;
import com.abir.bijoux.entities.User;
import com.abir.bijoux.service.BijouxService;
import com.abir.bijoux.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class BijouxApplication implements CommandLineRunner {
	@Autowired
	BijouxService bijouxService;
	@Autowired
	UserService	userService;
	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BijouxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	// System.out.println("Password Encoded BCRYPT :******************** ");
		//System.out.println(passwordEncoder.encode("123"));
		
		/*
		 * bijouxService.saveBijoux(new Bijoux("bracelet",20.000 ,new Date()));
		 * bijouxService.saveBijoux(new Bijoux("collier",50.000 ,new Date()));
		 * bijouxService.saveBijoux(new Bijoux("bague",40.000 ,new Date()));
		 * 
		 * 
		 */
	}
		/* @PostConstruct 
		 void init_users() { 
		  //ajouter les rôles 
		  userService.addRole(new Role(null,"ADMIN")); 
		  userService.addRole(new Role(null,"AGENT")); 
		  userService.addRole(new Role(null,"USER")); 
		   
		  //ajouter les users 
		  userService.saveUser(new User(null,"admin","123",true,null)); 
		  userService.saveUser(new User(null,"abir","123",true,null)); 
		  userService.saveUser(new User(null,"user1","123",true,null)); 
		   
		  //ajouter les rôles aux users 
		  userService.addRoleToUser("admin", "ADMIN"); 
		   
		  userService.addRoleToUser("abir", "USER"); 
		  userService.addRoleToUser("abir", "AGENT"); 
		   
		  userService.addRoleToUser("user1", "USER");   
		 
	}*/
	
}
