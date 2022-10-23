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
import com.Payroll.Repository.Leave_Repository;
import com.Payroll.Exception.ResourceNotFoundException;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class Leave_Controller {

	@Autowired
	private Leave_Repository leaveRepository;
	
	// get all employees leave Details
	@GetMapping("/leave")
	public List<Leave> getAllLeaveDetails(){
		return leaveRepository.findAll();
	}		
	
	// create Leave rest api
	@PostMapping("/leave")
	public Leave addLeave(@RequestBody Leave leave) {
		return leaveRepository.save(leave);
	}
	
	// get employee by id rest api
	@GetMapping("/leave/{id}")
	public ResponseEntity<Leave> getLeaveById(@PathVariable Long id) {
		Leave leave = leaveRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(leave);
	}
	
	// update leave Details rest api
	
	@PutMapping("/leave/{id}")
	public ResponseEntity<Leave> updateLeave(@PathVariable Long id, @RequestBody Leave leaveDetails){
		Leave leave = leaveRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
	
		leave.setName(leaveDetails.getName());
		leave.setEmail_Id(leaveDetails.getEmail_Id());
		leave.setToDate(leaveDetails.getToDate());
		leave.setFromDate(leaveDetails.getFromDate());
		leave.setDescription(leaveDetails.getDescription());
		
		Leave updatedLeaveDetails = leaveRepository.save(leave);
		return ResponseEntity.ok(updatedLeaveDetails);
	}
	
	// delete leave rest api
	@DeleteMapping("/leave/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteLeave(@PathVariable Long id){
		Leave leave = leaveRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		leaveRepository.delete(leave);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}