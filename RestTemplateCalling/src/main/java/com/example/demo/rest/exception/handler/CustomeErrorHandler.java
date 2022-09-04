package com.example.demo.rest.exception.handler;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestControllerAdvice
public class CustomeErrorHandler {	
	@SuppressWarnings("unchecked")
	@ExceptionHandler(RestCustomeError.class)
	ResponseEntity<Map<String,String>> handleRestClientError(RestCustomeError ce){
		Map<String, String> errorMap = null;
		try {
			errorMap = new ObjectMapper().readValue(ce.getErrorMessage(), Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<Map<String,String>>(errorMap, ce.getHttpStatusCode());
	}

}
