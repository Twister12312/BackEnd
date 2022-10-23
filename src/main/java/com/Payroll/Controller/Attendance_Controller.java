package com.Payroll.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Payroll.Entity.*;
import com.Payroll.Repository.*;
import com.Payroll.Exception.ResourceNotFoundException;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class Attendance_Controller {

	@Autowired
	private Attendance_Repository attendanceRepository;
	
	// get all employees
	@GetMapping("/attendees")
	public List<Attendance> getAttendees(){
		return attendanceRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/attendees")
	public Attendance addAttendees(@RequestBody Attendance attendance) {
		return attendanceRepository.save(attendance);
	}
	
	// get employee by id rest api
	@GetMapping("/attendees/{id}")
	public ResponseEntity<Attendance> getAttendeesById(@PathVariable Long id) {
		Attendance attendance = attendanceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(attendance);
	}
	
	// update employee rest api
	
	@PutMapping("/attendees/{id}")
	public ResponseEntity<Attendance> updateAttendees(@PathVariable Long id, @RequestBody Attendance AttendeesDetails){
		Attendance attendance = attendanceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
	
		attendance.setName(AttendeesDetails.getName());
		attendance.setEmail_Id(AttendeesDetails.getEmail_Id());
		attendance.setDate(AttendeesDetails.getDate());
		attendance.setStatus(AttendeesDetails.getStatus());
		
		Attendance updatedEmployee = attendanceRepository.save(attendance);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@DeleteMapping("/attendees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAttendees(@PathVariable Long id){
		Attendance attendance =attendanceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		attendanceRepository.delete(attendance);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}