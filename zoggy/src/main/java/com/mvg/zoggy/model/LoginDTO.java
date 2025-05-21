package com.mvg.zoggy.model;

public class LoginDTO {
	private int id;
	private String username;
	private String password;
	private long phnumber;
	private String email;
	private String jwt;
	
	public LoginDTO(int id, String username, String password, long phnumber,String email, String jwt) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.username = username;
        this.password = password;
        this.phnumber = phnumber;
        this.email = email;
        this.jwt = jwt;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhnumber() {
		return phnumber;
	}

	public void setPhnumber(long phnumber) {
		this.phnumber = phnumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
}
