package com.sourcecloud.jdbcdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sourcecloud.jdbcdemo.model.Employee;
import com.sourcecloud.jdbcdemo.service.StudentService;
import com.sourcecloud.jdbcdemo.service.impl.StudentServiceImpl;

@RestController("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService; 
	
	
	
	@GetMapping
	public List<Employee> getStudent(@RequestParam(required=false) String gender) {
		
		List<Employee> students = studentService.getStudents();
		
		List<Employee> filteredStudents = new ArrayList<Employee>();
		
		if(gender == null) {
			filteredStudents.addAll(students);
		} else {
			for (Employee student : students) {
				if(gender.equalsIgnoreCase(student.getGender())) {
					filteredStudents.add(student);
				}
			}
		}
		return filteredStudents;
		
	}
	
	
	
	@PostMapping
	public void createStudent(@RequestBody Employee student) {
		
		 studentService.insertStudent(student);
		
		 List<Employee>FilteredStudent = new ArrayList<Employee>();
	}
	
	@PutMapping
	public void updateStudent(@RequestBody Employee student) {
		
	}

}
