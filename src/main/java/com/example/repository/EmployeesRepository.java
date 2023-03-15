package com.example.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Employees;

public interface EmployeesRepository extends MongoRepository<Employees, String> {

}
