package com.student.studentdetails.service;

import java.util.List;

import com.student.studentdetails.Dao.StudentDao;
import com.student.studentdetails.entities.Student;
import com.student.studentdetails.exception.ResourceNotFoundException;

public interface StudentService {
	
	 public List<Student> getAllStudents();
	 public Student getstudentById(Long id) throws ResourceNotFoundException;
	 public Student createstudent(Student data);
	 public String updatestudent(Long id,StudentDao Data) throws ResourceNotFoundException;
	 public boolean deletestudent(Long id) throws ResourceNotFoundException;
}
