package com.hcl.timesheet.exception;

public class PlaceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PlaceNotFoundException(String message) {
		super(message);
	}
	
}