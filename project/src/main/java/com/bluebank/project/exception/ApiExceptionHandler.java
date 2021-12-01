package com.bluebank.project.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException e, WebRequest request){
		ApiException exception = new ApiException(request.getDescription(false), e, HttpStatus.NOT_FOUND, ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}
}
