package com.mypack.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Requests {
	@Id
	private int id;
	private String uname;
	private int pid;
	private String pname;
	private int quantity;
	
	public Requests() {
		super();
	}
	
	public Requests(int id,String uname, int pid, String pname, int quantity) {
		super();
		this.id=id;
		this.uname = uname;
		this.pid = pid;
		this.pname = pname;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQuantity() {
		
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Requests [id=" + id + ", uname=" + uname + ", pid=" + pid + ", pname=" + pname + ", quantity="
				+ quantity + "]";
	}
	
	
}
