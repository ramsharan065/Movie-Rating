package com.lf.movie.auth.dto;

public class User {
	protected int userId;
	protected String username;
	protected String name;
	protected String role;
	public User(int userId, String username, String name, String role){
		this.userId = userId;
		this.username = username;
		this.name = name;
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public String getUsername() {
		return username;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
}
