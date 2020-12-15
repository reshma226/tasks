package com.mypack.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Error extends Exception {
	private static final long serialVersionUID = 1L;

	public Error(String message){
    	super(message);
}
}