package com.hcl.training.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(BankException.class)
//	public ResponseEntity<Error> ecomorseExceptionHandler(BankException ex, WebRequest request) {
//		Error errorResponse = new Error();
//		errorResponse.setMessage(ex.getMessage());
//
//		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//
//	}
//
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<Error> globalExceptionHandler(Exception exception, WebRequest request) {
//		Error errorResponse = new Error();
//		errorResponse.setMessage(exception.getMessage());
//
//		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//
//	}

	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<ExceptionData> globalExceptionHandler(UserNotFound ex, WebRequest request) {

		ExceptionData user = new ExceptionData(ex.getMessage());

		return new ResponseEntity<ExceptionData>(user, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidCredentials.class)
	public ResponseEntity<ExceptionData> globalExceptionHandler(InvalidCredentials ex, WebRequest request) {

		ExceptionData user = new ExceptionData(ex.getMessage());

		return new ResponseEntity<ExceptionData>(user, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoTransactions.class)
	public ResponseEntity<ExceptionData> globalExceptionHandler(NoTransactions ex, WebRequest request) {

		ExceptionData user = new ExceptionData(ex.getMessage());

		return new ResponseEntity<ExceptionData>(user, HttpStatus.NOT_FOUND);
	}

}