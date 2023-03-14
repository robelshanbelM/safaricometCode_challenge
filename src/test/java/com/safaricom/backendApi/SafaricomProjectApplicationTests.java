package com.safaricom.backendApi;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.safaricom.backendApi.Entitys.Users;
import com.safaricom.backendApi.Services.UsersService;



@RunWith(SpringRunner.class)
@SpringBootTest
class SafaricomProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	
	@MockBean
	UsersService usersService;
	
	@Test

	
	public void saveUser() {
		
	
		Users usersinfo= new Users(1, "frank", "12345", "ROLE_ADMIN");
		
		when(usersService.saveUserInfo(usersinfo)).thenReturn(usersinfo);
		
		assertEquals(usersinfo, usersService.saveUserInfo(usersinfo));
		
	
	}
	
	
	

	@Test
	
	public void getUsers() {
		
		Users usersinfo= new Users(1, "frank", "12345", "ROLE_ADMIN");
		Users usersinfo2= new Users(1, "robel", "1234578", "ROLE_USER");
		
		List<Users>list= new ArrayList<>();
		list.add(usersinfo);
		list.add(usersinfo2);
		
		when(usersService.listOfUser()).thenReturn(list);
		
		assertEquals( list , usersService.listOfUser() );
		
		
		
		
	}
	
}
