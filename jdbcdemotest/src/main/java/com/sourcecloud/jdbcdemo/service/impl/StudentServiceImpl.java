package com.sourcecloud.jdbcdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sourcecloud.jdbcdemo.dao.StudentDao;
import com.sourcecloud.jdbcdemo.model.Student;
import com.sourcecloud.jdbcdemo.service.StudentService;

@Component
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<Student> getStudents() {
		List<Student> students = studentDao.getStudents();
		
		return students;
	}

	@Override
	public void insertStudent(Student student) {
		studentDao.createStudent(student);
		
	}

	
}
