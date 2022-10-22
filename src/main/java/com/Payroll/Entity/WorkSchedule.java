package com.Payroll.Entity;

import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class WorkSchedule {
	@Id
    private long Employee_Id;
	private String Name;
	private Date date;
    private String Shift;
	private String startingTime;
	private String endTime;
	private String Duration;
	
	
	public WorkSchedule() {
		  
	  }


	public WorkSchedule(long employee_Id, String name, Date date, String shift, String startingTime, String endTime,
			String duration) {
		super();
		Employee_Id = employee_Id;
		Name = name;
		this.date = date;
		Shift = shift;
		this.startingTime = startingTime;
		this.endTime = endTime;
		Duration = duration;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getShift() {
		return Shift;
	}


	public void setShift(String shift) {
		Shift = shift;
	}


	public String getStartingTime() {
		return startingTime;
	}


	public void setStartingTime(String startingTime) {
		this.startingTime = startingTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getDuration() {
		return Duration;
	}


	public void setDuration(String duration) {
		Duration = duration;
	}

	 }