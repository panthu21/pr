package com.sourcecloud.jdbcdemo.service;

import java.util.List;

import com.sourcecloud.jdbcdemo.model.Employee;

public interface StudentService {
	
	List<Employee> getStudents();
	
	void insertStudent(Employee student);

	void updateStudent(Employee updatestudent);

}
