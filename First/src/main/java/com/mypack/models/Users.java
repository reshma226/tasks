package com.mypack.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
	
	@Id
	private long id;
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private String mail;
	private long phno;
	
		
		
	public Users(long id,String username, String firstname, String lastname, String password, String mail, long phno) {
		super();
		this.id=id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.mail = mail;
		this.phno = phno;
		
	}


	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", password=" + password + ", mail=" + mail + ", phno=" + phno + "]";
	}
	

}
