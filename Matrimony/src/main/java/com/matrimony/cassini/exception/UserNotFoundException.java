package com.matrimony.cassini.exception;

public class UserNotFoundException extends Exception {
	
	private static final long serialVersionUID = -6782010313316599660L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
