package com.registration.teacher.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionalHandlerAPI{
	
	@ExceptionHandler(value = {NotFoundException.class})
	public ResponseEntity<Object> handleAnyRequest(NotFoundException ex,WebRequest request)
	{
		return new ResponseEntity<>(ex.getLocalizedMessage(),new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {InputException.class})
	public ResponseEntity<Object> handleAnyRequest(InputException ex,WebRequest request)
	{
		return new ResponseEntity<>(ex.getLocalizedMessage(),new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationExceptionHandling(MethodArgumentNotValidException exception)
	{
		ErrorDetails errorDetails=
				               new ErrorDetails(new Date(), "Validation Error",exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
}
