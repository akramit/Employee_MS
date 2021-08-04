package com.io;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class login {
	
	@Id
	private int empId;
	private String passwd;
	private String role;
	
	
	public login() {	
	}
	
	public login(int empId, String password, String role) {
		super();
		this.empId = empId;
		this.passwd = password;
		this.role = role;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getPassword() {
		return passwd;
	}
	public void setPassword(String password) {
		this.passwd = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "login [empId=" + empId + ", password=" + passwd + ", role=" + role + "]";
	}
	
	

}
