package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Department;
import com.example.service.DepartmnetService;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/department")
@Tag(name = "Api-Department")
public class DepartmentController {

	private final DepartmnetService service;

	public DepartmentController(DepartmnetService service) {
		this.service = service;
	}

	@PostMapping("/add")
	public ResponseEntity<Department> cerateDepartment(@RequestBody Department department) {
		return service.cerateDepartment(department);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Department>> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/byDpmId/{dpmId}")
	public ResponseEntity<Department> getByDepartmentId(@PathVariable("dpmId") String dpmId) {
		return service.getByDepartmentId(dpmId);
		
	}
	
	@DeleteMapping("/deleteByDpmId/{dpmId}")
	public ResponseEntity<HttpStatus> deleteByDpmId(@PathVariable("dpmId") String dpmId) {
		return service.deleteByDepartmentId(dpmId);
		
	}
	

		


}
