package com.example.model;

import org.springframework.data.annotation.Id;

import lombok.Data;


@Data
public class Department {
	
	@Id
	private String id;
	private String dpmId;
	private String name;

}
