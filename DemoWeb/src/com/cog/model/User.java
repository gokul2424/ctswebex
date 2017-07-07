package com.cog.model;

public class User {
	
	String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	String pwd;
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public User(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", pwd=" + pwd + "]";
	}

}
