package com.application.exception;

public class BusinessException extends Exception {


	private static final long serialVersionUID = 8517679241790872844L;

	public String message;
		
	public BusinessException() {
	}
	
	public BusinessException(String message) {
		this.message= message;
	}
	
	
	public BusinessException(String message, Throwable th) {
		this.message= message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
