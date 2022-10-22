package com.Payroll.Entity;

import javax.persistence.Entity;
import java.sql.Date;
import javax.persistence.Id;

@Entity
public class Attendance {
	@Id
	private long Employee_Id;
	private String Name;
	private String Email_Id;
	private Date date;
	private String Status;
	
	public Attendance(long employee_Id, String name, String email_Id, Date date1, String status) {
		super();
		Employee_Id = employee_Id;
		Name = name;
		Email_Id = email_Id;
		date = date1;
		Status = status;
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
	public String getEmail_Id() {
		return Email_Id;
	}
	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date1) {
		date = date1;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	

}