package com.application.exception;

public class DaoException extends Exception {


	private static final long serialVersionUID = 8517679241790872844L;

	public String message;
		
	public DaoException() {
	}
	
	public DaoException(String message) {
		this.message= message;
	}
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
