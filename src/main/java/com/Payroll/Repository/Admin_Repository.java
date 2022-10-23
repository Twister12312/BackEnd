package com.Payroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Payroll.Entity.*;

@Repository
public interface Admin_Repository extends JpaRepository<Admin, Long>{

}

