package com.sourcecloud.jdbcdemo.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

import com.sourcecloud.jdbcdemo.dao.StudentDao;
import com.sourcecloud.jdbcdemo.model.Student;

@Component
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Student> getStudents() {
		
		List<Student> students = new ArrayList<Student>();
		
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM student");
		
		for (Map<String, Object> row : rows) {
			
			Student st = new Student();
			st.setId((int)(row.get("ID")));
			st.setName((String)row.get("NAME"));
			st.setGender((String)row.get("gender"));
			st.setDob((String)row.get("dob"));
			
			students.add(st);
		}
		
				
		
		
		return students;
	}

	@Override
	public void createStudent(Student student) {
		
		String sql = "INSERT INTO STUDENT VALUES (?, ?, ?, ?)";
		
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>(){  
		    

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1,student.getId());  
		        ps.setString(2,student.getName());  
		        ps.setString(3,student.getDob()); 
		        ps.setString(4,student.getGender());
		        return ps.execute();  
			}  
		    });  
		
		

	}

	@Override
	public void updateStuden(Student student) {
		
		String SQL = "update Student set name = ? where id = ?";
		jdbcTemplate.update(SQL, student.getName(), student.getId());
				
	    System.out.println("Updated Record with ID = " + student.getId() );
	      
	
	      
		
		
		
		
	}

}
