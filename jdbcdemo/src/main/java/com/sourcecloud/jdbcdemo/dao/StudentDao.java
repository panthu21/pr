package com.sourcecloud.jdbcdemo.dao;

import java.util.List;

import com.sourcecloud.jdbcdemo.model.Student;

public interface StudentDao {

	List<Student> getStudents();
	void createStudent(Student student);
	void updateStuden(Student student);
	
}
