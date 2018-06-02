package com.learn.exceptions;

public final class MyBadRequestException extends RuntimeException{

	public MyBadRequestException() {
		super();
	}

	public MyBadRequestException(String message) {
		super(message);
	}

}
