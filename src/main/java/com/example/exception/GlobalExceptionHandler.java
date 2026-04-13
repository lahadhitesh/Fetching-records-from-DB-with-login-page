package com.example.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	// 1. Handle Resource Not Found
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(
				ex.getMessage(), 
				HttpStatus.NOT_FOUND.value(),
				LocalDateTime.now());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	// 2. Handle IllegalArgumentException (Bad Request)
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleBadRequest(IllegalArgumentException ex) {
		ErrorResponse error = new ErrorResponse(
				ex.getMessage(), 
				HttpStatus.BAD_REQUEST.value(), 
				LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	// 3. Handle all other exceptions (Fallback)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
		ErrorResponse ErrorResponse = new ErrorResponse(
				"Something went wrong",
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				LocalDateTime.now());
		return new ResponseEntity<>(ErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
