package com.sourcecloud.jdbcdemo.service;

import java.util.List;

import com.sourcecloud.jdbcdemo.model.Student;

public interface StudentService {
	
	List<Student> getStudents();
	
	void insertStudent(Student student);

}
