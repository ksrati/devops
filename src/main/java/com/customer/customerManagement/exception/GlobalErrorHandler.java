package com.customer.customerManagement.exception;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {

	
	@ExceptionHandler(CustomerNotFoundException.class)
    protected ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError error = new CustomError(status.value(), ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(status).body(error);
    }
	
	

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomError> handleException(Exception ex) {
        CustomError error = new CustomError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
    

    
}
