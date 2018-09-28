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

import com.sourcecloud.jdbcdemo.model.Student;
import com.sourcecloud.jdbcdemo.service.StudentService;

@RestController("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService; 
	
	@GetMapping
	public List<Student> getStudent(@RequestParam(required=false) String gender) {
		
		List<Student> students = studentService.getStudents();
		
		List<Student> filteredStudents = new ArrayList<Student>();
		
		if(gender == null) {
			filteredStudents.addAll(students);
		} else {
			for (Student student : students) {
				if(gender.equalsIgnoreCase(student.getGender())) {
					filteredStudents.add(student);
				}
			}
		}
		
		
		return filteredStudents;
		
	}
	
	
	
	@PostMapping
	public void createStudent(@RequestBody Student student) {
		
		 studentService.insertStudent(student);
		
		 List<Student>FilteredStudent = new ArrayList<Student>();
	}
	
	@PutMapping
	public void updateStudent(@RequestBody Student student) {
		
	}

}
