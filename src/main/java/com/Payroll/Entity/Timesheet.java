package com.Payroll.Entity;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="timesheet")
public class Timesheet {
	
	@Id
	private long Employee_Id;
	private String Name;
	
	private String Email_Id;
	private Date date;
	private int Hours;
	private String Description;
	public Timesheet(long employee_Id, String name,String email_Id, Date date, int hours, String description) {
		super();
		Employee_Id = employee_Id;
		Name=name;
		Email_Id = email_Id;
		this.date = date;
		Hours = hours;
		Description = description;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getEmployee_Id() {
		return Employee_Id;
	}
	public void setEmployee_Id(long employee_Id) {
		Employee_Id = employee_Id;
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
	public void setDate(Date date) {
		this.date = date;
	}
	public int getHours() {
		return Hours;
	}
	public void setHours(int hours) {
		Hours = hours;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	
}