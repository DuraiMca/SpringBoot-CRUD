package com.student.studentdetails.exception;

public class ResourceNotFoundException extends Exception{
	
	String message;

	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}
	

}
