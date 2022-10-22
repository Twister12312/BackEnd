package com.Payroll.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Salary {
	@Id
	private long Employee_Id;
	private String Name;
	private int date;
	private String Month;
	private Double Amount;
	
	public Salary() {
	}
	public Salary(long employee_Id, String name, int date, String month, Double amount) {
		super();
		Employee_Id = employee_Id;
		Name = name;
		this.date = date;
		Month = month;
		Amount = amount;
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
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getMonth() {
		return Month;
	}
	public void setMonth(String month) {
		Month = month;
	}
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}


	

}