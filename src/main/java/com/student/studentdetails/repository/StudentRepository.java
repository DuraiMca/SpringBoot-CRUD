package com.student.studentdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.student.studentdetails.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
	

}
