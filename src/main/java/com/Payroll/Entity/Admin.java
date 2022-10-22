package com.Payroll.Entity;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Admin_Id;
	private String Name;
	private Date DOB;
	private int Mobileno;
	private String Designation;
	private String Gender;
	private String Email_Id;
	private String Home_Address;

	public Admin(long admin_Id, String name, Date dOB, int mobileno, String designation, String gender,
			String email_Id, String home_Address) {
		super();
		Admin_Id = admin_Id;
		Name = name;
		DOB = dOB;
		Mobileno = mobileno;
		Designation = designation;
		Gender = gender;
		Email_Id = email_Id;
		Home_Address = home_Address;
	}
	
	public long getAdmin_Id() {
		return Admin_Id;
	}
	public void setAdmin_Id(long admin_Id) {
		Admin_Id = admin_Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public int getMobileno() {
		return Mobileno;
	}
	public void setMobileno(int mobileno) {
		Mobileno = mobileno;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmail_Id() {
		return Email_Id;
	}
	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}
	public String getHome_Address() {
		return Home_Address;
	}
	public void setHome_Address(String home_Address) {
		Home_Address = home_Address;
	}
	
	
}

