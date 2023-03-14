package com.safaricom.backendApi.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "user_Table")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int users_Id;
	
	@NotBlank
	private String login;
	
	@NotBlank
	
	private String password;
	@NotBlank
	private String roles;
	
	public int getUsers_Id() {
		return users_Id;
	}
	public void setUsers_Id(int users_Id) {
		this.users_Id = users_Id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int users_Id, @NotBlank String login, @NotBlank String password, @NotBlank String roles) {
		super();
		this.users_Id = users_Id;
		this.login = login;
		this.password = password;
		this.roles = roles;
	}
	
	
}
