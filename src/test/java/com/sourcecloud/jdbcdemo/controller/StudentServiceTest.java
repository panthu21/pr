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

import com.sourcecloud.jdbcdemo.dao.StudentDao;
import com.sourcecloud.jdbcdemo.model.Employee;
import com.sourcecloud.jdbcdemo.service.impl.StudentServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {
	@Mock
	private StudentDao studentDao;
	@InjectMocks
	private StudentServiceImpl unitUnderTest;
	
	
	@Test
	public void getStudent() {
		List<Employee> students = new ArrayList<Employee>();
		
		Employee em1 = new Employee();
		em1.setGender("M");
		em1.setName("prasanth");
		em1.setId(1);
		students.add(em1);
		
		Employee em2 = new Employee();
		em2.setGender("F");
		em2.setName("rupa");
		em2.setId(2);
		students.add(em2);
		
		
		
		when(studentDao.getStudents()).thenReturn(students);
		
		List<Employee> response = unitUnderTest.getStudents();
		
		response.get(0);
		
		Assert.assertEquals("prasanth", response.get(0).getName());
		
	}
}