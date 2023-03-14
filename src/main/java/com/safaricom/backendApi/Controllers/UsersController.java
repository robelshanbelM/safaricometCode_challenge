package com.safaricom.backendApi.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safaricom.backendApi.Entitys.Users;
import com.safaricom.backendApi.Services.UsersService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/v1/user")
public class UsersController {

	@Autowired
	UsersService usersService;
	
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/")
	
	public ResponseEntity<?> addUsers(@RequestBody @Valid  Users users){
		
		
	
		try {
	
			 users.setPassword(encoder.encode(users.getPassword()));
			return new ResponseEntity<Object>(usersService.saveUserInfo(users),HttpStatus.CREATED);
			
		} catch (Exception e) {
			// TODO: handle exception
	
			 return new ResponseEntity<String>("Error BAD_REQUEST ",HttpStatus.BAD_REQUEST);
	
		}
	
		
	}
	
   @GetMapping("/")	

   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> allusers(){
	   
	   
	try {
		 return new ResponseEntity<Object>(usersService.listOfUser(),HttpStatus.OK);

	} catch (Exception e) {
		// TODO: handle exception
	
		 return new ResponseEntity<String>("SERVICE UNAVAILABLE",HttpStatus.SERVICE_UNAVAILABLE);

	}  
   
   }
	
   
}
