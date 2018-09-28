package com.sourcecloud.jdbcdemo.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sourcecloud.jdbcdemo.model.Employee;
import com.sourcecloud.jdbcdemo.service.StudentService;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {
	
	@Mock
	private StudentService studentService;
	
	@InjectMocks
	private StudentController unitUnderTest;
	

	@Test
	public void getStudent_success_with_gender() {
		List<Employee> students = new ArrayList<Employee>();
		
		Employee em1 = new Employee();
		em1.setGender("M");
		em1.setName("prasanth");
		em1.setId(1);
		students.add(em1);
		
		Employee em2 = new Employee();
		em2.setGender("F");
		em2.setName("prasanthi");
		em2.setId(2);
		students.add(em2);
		
		
		
		when(studentService.getStudents()).thenReturn(students);
		
		List<Employee> response = unitUnderTest.getStudent("M");
		
		response.get(0);
		
		Assert.assertEquals("prasanth", response.get(0).getName());
		
	}
	
	@Test
	public void getStudent_success_no_gender() {
		List<Employee> students = new ArrayList<Employee>();
		Employee em1 = new Employee();
		em1.setGender("M");
		em1.setName("prasanth");
		em1.setId(1);
		students.add(em1);
		
		Employee em2 = new Employee();
		em2.setGender("F");
		em2.setName("prasanthi");
		em2.setId(2);
		students.add(em2);
		
		
		when(studentService.getStudents()).thenReturn(students);
		
		List<Employee> response = unitUnderTest.getStudent(null);
		
		
		Assert.assertEquals("prasanth", response.get(0).getName());
		Assert.assertEquals("prasanthi", response.get(1).getName());
		
	}

	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
