package com.safaricom.backendApi.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class appExceptionHandler {

	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public Map<String, String>handleinvalidArgs(MethodArgumentNotValidException ex){
	
		
		Map<String, String>errorMap= new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error ->{
			
			errorMap.put(error.getField() , error.getDefaultMessage());
			
		});
		return errorMap;
	}
}
