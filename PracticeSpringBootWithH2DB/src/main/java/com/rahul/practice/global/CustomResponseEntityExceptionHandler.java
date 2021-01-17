package com.rahul.practice.global;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rahul.practice.common.exception.ExceptionResponse;
import com.rahul.practice.common.exception.UserNotFoundException;

@ControllerAdvice(annotations=RestController.class)
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex,WebRequest request){
		ExceptionResponse exResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		System.out.println(exResponse);
		return new ResponseEntity<>(exResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> userNotFoundException(Exception ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);

	}
}
