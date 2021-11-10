package com.employeeapp.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employeeapp.dto.ErrorResponse;
import com.employeeapp.exception.DuplicateEmployeeException;

@RestControllerAdvice
public class EmployeeErrorController {
	
	@ExceptionHandler(DuplicateEmployeeException.class)
	@ResponseStatus(code=HttpStatus.NOT_ACCEPTABLE)
	public ErrorResponse handleDuplicateEmployeeException(DuplicateEmployeeException ex, HttpServletRequest request) {
		
		return new ErrorResponse(LocalDateTime.now(), 
									HttpStatus.NOT_ACCEPTABLE.value(), 
									ex.getClass().getSimpleName(), 
									ex.getMessage(), 
									request.getRequestURI()
									);
				
		
	}
	
	@ExceptionHandler(HttpMessageConversionException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorResponse handleHttpMessageConversionException(HttpMessageConversionException ex, HttpServletRequest request) {
		
		return new ErrorResponse(LocalDateTime.now(), 
									HttpStatus.BAD_REQUEST.value(), 
									ex.getClass().getSimpleName(), 
									ex.getMessage(), 
									request.getRequestURI()
									);
				
		
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleOtherException(Exception ex, HttpServletRequest request) {
		
		return new ErrorResponse(LocalDateTime.now(), 
									HttpStatus.INTERNAL_SERVER_ERROR.value(), 
									ex.getClass().getSimpleName(), 
									ex.getMessage(), 
									request.getRequestURI()
									);
				
		
	}

}
