package com.Payroll.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Employee_Id;
	private String Name;
	private Date DOB;
	private int Mobileno;
	private String Gender;
	private String Email_Id;
	private String Home_Address;
	public Employee(long employee_Id, String name, Date dOB, int mobileno, String gender, String email_Id,
			String home_Address) {
		super();
		Employee_Id = employee_Id;
		Name = name;
		DOB = dOB;
		Mobileno = mobileno;
		Gender = gender;
		Email_Id = email_Id;
		Home_Address = home_Address;
	}
	public long getEmployee_Id() {
		return Employee_Id;
	}
	public void setEmployee_Id(long employee_Id) {
		Employee_Id = employee_Id;
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
