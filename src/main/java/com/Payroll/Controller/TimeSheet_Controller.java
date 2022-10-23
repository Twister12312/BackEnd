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
public class TimeSheet_Controller {

	@Autowired
	private Timesheet_Repository timesheetRepository;
	
	// get all employees leave Details
	@GetMapping("/timesheet")
	public List<Timesheet> getAllTimesheetList(){
		return timesheetRepository.findAll();
	}		
	
	// create Leave rest api
	@PostMapping("/timesheet")
	public Timesheet createTimesheet(@RequestBody Timesheet salary) {
		return timesheetRepository.save(salary);
	}
	
	// get employee by id rest api
	@GetMapping("/timesheet/{id}")
	public ResponseEntity<Timesheet> getTimesheetById(@PathVariable Long id) {
		Timesheet timesheet = timesheetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(timesheet);
	}
	
	// update leave Details rest api
	
	@PutMapping("/timesheet/{id}")
	public ResponseEntity<Timesheet> updateTimesheet(@PathVariable Long id, @RequestBody Timesheet timesheetDetails){
		Timesheet timesheet=timesheetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
	
		timesheet.setName(timesheetDetails.getName());
		timesheet.setDate(timesheetDetails.getDate());
		timesheet.setEmail_Id(timesheetDetails.getEmail_Id());
		timesheet.setHours(timesheetDetails.getHours());
		timesheet.setDescription(timesheetDetails.getDescription());
		
		Timesheet updatedtimesheetDetails = timesheetRepository.save(timesheet);
		return ResponseEntity.ok(updatedtimesheetDetails);
	}
	
	// delete leave rest api
	@DeleteMapping("/timesheet/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTimesheet(@PathVariable Long id){
		Timesheet timesheet=timesheetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		timesheetRepository.delete(timesheet);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}