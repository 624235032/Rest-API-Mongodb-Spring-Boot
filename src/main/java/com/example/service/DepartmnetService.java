package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.Department;
import com.example.repository.DepartmentRepository;

@Service
public class DepartmnetService {

	private final DepartmentRepository repository;

	public DepartmnetService(DepartmentRepository repository) {
		this.repository = repository;

	}

	public ResponseEntity<Department> cerateDepartment(Department department) {

		Department newDpm = repository.save(department);
		try {
			return new ResponseEntity<>(newDpm, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	public ResponseEntity<List<Department>> getAll() {
		try {
			return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	public ResponseEntity<Department> getDepartmentById(String id) {
		try {
			// check id department in database
			Department dpmObj = getDpmId(id);

			if (dpmObj != null) {
				return new ResponseEntity<>(dpmObj, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	public ResponseEntity<Department> getByDepartmentId(String dpmId) {
		try {
			// check dpmId in database
			Department dpmObj = getByDpmId(dpmId); 

			if (dpmObj != null) {
				return new ResponseEntity<>(dpmObj, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	public ResponseEntity<HttpStatus> deleteByDepartmentId(String dpmId){
		try {
			Optional<Department> dpmobj = repository.findByDpmId(dpmId);
			
			if (dpmobj != null) {
				repository.deleteByDpmId(dpmId);
				return new ResponseEntity<>(HttpStatus.OK);
				
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	private Department getDpmId(String id) {
		Optional<Department> dpmObj = repository.findById(id);

		if (dpmObj.isPresent()) {
			return dpmObj.get();
		}
		return null;

	}
	
	private Department getByDpmId(String dpmId) {
		Optional<Department> dpmObj = repository.findByDpmId(dpmId);

		if (dpmObj.isPresent()) {
			return dpmObj.get();
		}
		return null;

	}
	
}
