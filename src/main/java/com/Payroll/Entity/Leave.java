package com.Payroll.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leave")
public class Leave {
	@Id
    private long Employee_Id;
	private String Name;
	private String Email_Id;
	private Date ToDate;
	private String FromDate;
    private String Description;
	
	
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
	public Date getToDate() {
		return ToDate;
	}
	public void setToDate(Date toDate) {
		ToDate = toDate;
	}
	public String getFromDate() {
		return FromDate;
	}
	public void setFromDate(String fromDate) {
		FromDate = fromDate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	public Leave(long employee_Id, String name, String email_Id, Date toDate, String fromDate, String description) {
		super();
		Employee_Id = employee_Id;
		Name = name;
		Email_Id = email_Id;
		ToDate = toDate;
		FromDate = fromDate;
		Description = description;
	}
    
}