package com.sourcecloud.jdbcdemo.dao;

import java.util.List;

import com.sourcecloud.jdbcdemo.model.Employee;

public interface StudentDao {

	List<Employee> getStudents();
	void createStudent(Employee student);
	void updateStuden(Employee student);
	
}
