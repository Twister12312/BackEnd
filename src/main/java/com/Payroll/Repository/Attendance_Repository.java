package com.Payroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Payroll.Entity.Attendance;

public interface Attendance_Repository extends JpaRepository<Attendance,Long> {

}
