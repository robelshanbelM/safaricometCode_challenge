package com.safaricom.backendApi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safaricom.backendApi.Entitys.Users;
import com.safaricom.backendApi.Repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository usersRepository;
    
	//save user info
	
	public Users saveUserInfo(Users users ) {
		
		
		return usersRepository.save(users);
		
	}
	
// list of users
	
    public List<Users> listOfUser(){
	   
	   
	   return usersRepository.findAll();
   }

//Update Users by ID
    
    
    public Users updateUserById(int id  , Users users) {
    	
    	
    	Optional<Users> finduser=usersRepository.findById(id);
    	
    	if (finduser.isPresent()) {
			
    		Users users2= finduser.get();
    		
    		users2.setLogin(users.getLogin());
    		users2.setPassword(users.getPassword());
    		
    		return usersRepository.save(users2);
    	}
    	
    	else {
    		
    		
    		return users;
    	}
    	
    }
   
//Delete user by id    
  
    
    public String deleteUserByid(int id) {
    	
    	
    	Optional<Users>finduser=usersRepository.findById(id);
    	
    	if (finduser.isPresent()) {
			
    		usersRepository.deleteById(id);
    		
    		return "User id deleted ";
		}
    	
    	else {
    		
    		return "unable to find this user";
    	}
    } 
   
    
}
