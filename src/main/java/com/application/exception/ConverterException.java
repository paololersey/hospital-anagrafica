package com.application.exception;

public class ConverterException extends Exception {


	private static final long serialVersionUID = 8517679241790872844L;

	public String message;
		
	public ConverterException() {
	}
	
	public ConverterException(String message) {
		this.message= message;
	}
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
