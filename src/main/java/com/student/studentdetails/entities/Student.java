package com.student.studentdetails.entities;

import com.student.studentdetails.constants.ApplicationConstant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "dateofbirth")
  private String dateofbirth;

  @Column(name = "dateofjoining")
  private String dateofjoining;
  
  @Column(name = "classes")
  private String classes;

  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + ", dateofbirth=" + dateofbirth + ", dateofjoining=" + dateofjoining + ",classes=" + classes + " ]";
  }

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDateofbirth() {
	return dateofbirth;
}

public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}

public String getDateofjoining() {
	return dateofjoining;
}

public void setDateofjoining(String dateofjoining) {
	this.dateofjoining = dateofjoining;
}

public String getClasses() {
	return classes;
}

public void setClasses(String classes) {
	this.classes = classes;
}
  

}