package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Emp;
import com.service.EmpService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/api/v1/")
public class EmpController {

	@Autowired
	EmpService empService;
	
	@PostMapping("/save")
	public ResponseEntity<Emp> createEmp(@RequestBody Emp emp){
		
		return new ResponseEntity<Emp>(empService.createEmp(emp),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Emp>> getAllEmp(){
		return new ResponseEntity<List<Emp>>(empService.getAllEmp(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Emp> getEmpById(@PathVariable Integer id){
		return new ResponseEntity<Emp> (empService.getEmpById(id),HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable Integer id) {
		empService.deleteEmp(id);
		return new ResponseEntity<String>("Delete Successfully",HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Emp> updateEmp(@PathVariable Integer id,@RequestBody Emp emp){
		
		return new ResponseEntity<Emp>(empService.updateEmp(id, emp),HttpStatus.OK);  
	}
}
