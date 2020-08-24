package com.boot1.kavi.User.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserExistsException.class)
	public final ResponseEntity<Object> handleHospitalNotFoundException(UserExistsException ex,
			WebRequest request) {
		CustomErrorDetails customeErrorDetails = new CustomErrorDetails(new Date(), ex.getMessage(), 
				request.getDescription(false));
		return new ResponseEntity<Object>(customeErrorDetails, HttpStatus.NOT_FOUND);
	}
	
}
