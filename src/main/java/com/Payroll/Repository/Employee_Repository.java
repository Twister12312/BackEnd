package com.Payroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Payroll.Entity.Employee;

@Repository
public interface Employee_Repository extends JpaRepository<Employee, Long>{

}
