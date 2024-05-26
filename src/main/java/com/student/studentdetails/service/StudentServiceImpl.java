package com.student.studentdetails.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.studentdetails.Dao.StudentDao;
import com.student.studentdetails.entities.Student;
import com.student.studentdetails.exception.ResourceNotFoundException;
import com.student.studentdetails.repository.StudentRepository;

import lombok.AllArgsConstructor;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;


	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getstudentById(Long id) throws ResourceNotFoundException {
		return studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student ID not available"));
	}

	@Override
	public Student createstudent(Student reqData) {
		return studentRepository.save(reqData);
	}
	
	@Override
	public String updatestudent(Long id, StudentDao reqData) throws ResourceNotFoundException {
		Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student ID not available"));
		student.setClasses(reqData.getClasses());
		student.setDateofbirth(reqData.getDateofbirth());
		student.setDateofjoining(reqData.getDateofjoining());
		student.setName(reqData.getName());
		student.setId(id);
		studentRepository.save(student);
		return "Data Updated";
	}

	@Override
	public boolean deletestudent(Long id) throws ResourceNotFoundException {
		Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student ID not available"));
		if(student!=null){
			studentRepository.deleteById(id);
			return true;
		}
		return false;
	}

}

