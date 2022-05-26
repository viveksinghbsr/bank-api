package com.cts.bank.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserRestExceptionController<CustomerErrorResponse> {

	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException e) {

		// create a UserErrorResponse

		UserErrorResponse error = new UserErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// add another exception handler...to catch all exceptions
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(Exception e) {

		// create a UserErrorResponse

		UserErrorResponse error = new UserErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

}
