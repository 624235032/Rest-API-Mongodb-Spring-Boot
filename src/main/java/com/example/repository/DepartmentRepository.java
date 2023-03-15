package com.example.repository;



import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Department;


public interface DepartmentRepository extends MongoRepository<Department, String> {


	Optional<Department> findByDpmId(String dpmId);
	
	Optional<Department> deleteByDpmId(String dpmId);

	
	


}
