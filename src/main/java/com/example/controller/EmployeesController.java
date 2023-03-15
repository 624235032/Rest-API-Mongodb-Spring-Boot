package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employees;
import com.example.service.EmployeesService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

	private final EmployeesService service;

	public EmployeesController(EmployeesService service) {
		this.service = service;
	}

	@GetMapping("/getAll")
	@Tag(name = "Get-Employees")
	public ResponseEntity<List<Employees>> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	@Tag(name = "Get-Employees")
	public ResponseEntity<Employees> getEmployeeById(@PathVariable("id") String id) {
		return service.getEmployeeById(id);
	}

	@PostMapping("/add")
	@Tag(name = "Add-Employees")
	public ResponseEntity<Employees> cerateEmployee(@RequestBody Employees employees) {
		return service.cerateEmployee(employees);
	}

	@DeleteMapping("/{id}")
	@Tag(name = "Delete-Employees")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable("id") String id) {
		return service.deleteEmployeeById(id);
	}

	@DeleteMapping("/DelAll")
	@Tag(name = "Delete-Employees")
	public ResponseEntity<HttpStatus> deleteAllEmployees() {
		return service.deleteAllEmployees();
	}

	@PutMapping("/{id}")
	@Tag(name = "Edit-Employees")
	public ResponseEntity<Employees> updateEmployee(@PathVariable("id") String id, @RequestBody Employees employees) {
		return service.updateEmployee(id, employees);

	}

}
