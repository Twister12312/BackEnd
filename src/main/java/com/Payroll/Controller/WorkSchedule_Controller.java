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
public class WorkSchedule_Controller {

	@Autowired
	private WorkSchedule_Repository workscheduleRepository;
	
	// get all employees leave Details
	@GetMapping("/workschedule")
	public List<WorkSchedule> getAllWorkScheduleList(){
		return workscheduleRepository.findAll();
	}		
	
	// create Leave rest api
	@PostMapping("/workschedule")
	public WorkSchedule createWorkSchedule(@RequestBody WorkSchedule workschedule) {
		return workscheduleRepository.save(workschedule);
	}
	
	// get employee by id rest api
	@GetMapping("/workschedule/{id}")
	public ResponseEntity<WorkSchedule> getWorkScheduleById(@PathVariable Long id) {
		WorkSchedule workschedule = workscheduleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(workschedule);
	}
	
	// update leave Details rest api
	
	@PutMapping("/workschedule/{id}")
	public ResponseEntity<WorkSchedule> updateWorkSchedule(@PathVariable Long id, @RequestBody WorkSchedule workscheduleDetails){
		WorkSchedule workschedule=workscheduleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
	
		workschedule.setName(workscheduleDetails.getName());
		workschedule.setDate(workscheduleDetails.getDate());
		workschedule.setShift(workscheduleDetails.getShift());
		workschedule.setStartingTime(workscheduleDetails.getStartingTime());
		workschedule.setEndTime(workscheduleDetails.getEndTime());
		workschedule.setDuration(workscheduleDetails.getDuration());
		
		WorkSchedule updatedworkscheduleDetails = workscheduleRepository.save(workschedule);
		return ResponseEntity.ok(updatedworkscheduleDetails);
	}
	
	// delete leave rest api
	@DeleteMapping("/workschedule/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSalary(@PathVariable Long id){
		WorkSchedule workschedule=workscheduleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		workscheduleRepository.delete(workschedule);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
