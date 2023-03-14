package com.safaricom.backendApi.SecurityConfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.safaricom.backendApi.Entitys.Users;
import com.safaricom.backendApi.Repositories.UsersRepository;

public class UserInfoUserDetailsService implements  UserDetailsService {

	@Autowired
	private UsersRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Users> userinfo=repository.findByLogin(login);
		
		return userinfo.map(UserInfoUserDetails :: new).orElseThrow(()->new UsernameNotFoundException("user is not found"));
	}

}