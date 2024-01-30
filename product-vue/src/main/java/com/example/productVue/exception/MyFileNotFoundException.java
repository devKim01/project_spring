package com.example.productVue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyFileNotFoundException extends RuntimeException{
	private static final long serialVeersionUID = 6034167892600448190L;
	
	public MyFileNotFoundException(String message) {
		super(message);
	}
	public MyFileNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
