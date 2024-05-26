package com.student.studentdetails.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.studentdetails.Dao.StudentDao;
import com.student.studentdetails.entities.Student;
import com.student.studentdetails.exception.ResourceNotFoundException;
import com.student.studentdetails.service.StudentService;
import com.student.studentdetails.service.StudentServiceImpl;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping(value="${api.path.prefix}")

@AllArgsConstructor

public class StudentController {
	@Autowired
	private StudentServiceImpl  service;

	@PostMapping("/register")
	public ResponseEntity<Student> insertStudent(@RequestBody Student req){
		 
		Student entity=service.createstudent(req);
	
	  return new ResponseEntity<>(entity, HttpStatus.CREATED);

}

	@GetMapping("/students/{id}")
	public ResponseEntity<?> getstudentById(@PathVariable("id") long id) throws ResourceNotFoundException {
			Student student = service.getstudentById(id);
			return new ResponseEntity<>(student,HttpStatus.OK);
	}
	@PutMapping("/students/{id}")
	public ResponseEntity<?> updatestudent(@PathVariable("id") long id, @RequestBody StudentDao data) throws ResourceNotFoundException {
			String student = service.updatestudent(id, data);
			return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<?> deletestudent(@PathVariable("id") long id) throws ResourceNotFoundException {
			boolean deleteStudent = service.deletestudent(id);
			return new ResponseEntity<>(deleteStudent, HttpStatus.OK);	}
	
}