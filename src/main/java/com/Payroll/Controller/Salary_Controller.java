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
public class Salary_Controller {

	@Autowired
	private Salary_Repository salaryRepository;
	
	// get all employees leave Details
	@GetMapping("/salary")
	public List<Salary> getAllSalaryList(){
		return salaryRepository.findAll();
	}		
	
	// create Leave rest api
	@PostMapping("/salary")
	public Salary createSalary(@RequestBody Salary salary) {
		return salaryRepository.save(salary);
	}
	
	// get employee by id rest api
	@GetMapping("/salary/{id}")
	public ResponseEntity<Salary> getSalaryById(@PathVariable Long id) {
		Salary salary = salaryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(salary);
	}
	
	// update leave Details rest api
	
	@PutMapping("/salary/{id}")
	public ResponseEntity<Salary> updateSalary(@PathVariable Long id, @RequestBody Salary salaryDetails){
		Salary salary=salaryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
	
		salary.setName(salaryDetails.getName());
		salary.setDate(salaryDetails.getDate());
		salary.setMonth(salaryDetails.getMonth());
		salary.setAmount(salaryDetails.getAmount());
		
		Salary updatedsalaryDetails = salaryRepository.save(salary);
		return ResponseEntity.ok(updatedsalaryDetails);
	}
	
	// delete leave rest api
	@DeleteMapping("/salary/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSalary(@PathVariable Long id){
		Salary salary=salaryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		salaryRepository.delete(salary);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}