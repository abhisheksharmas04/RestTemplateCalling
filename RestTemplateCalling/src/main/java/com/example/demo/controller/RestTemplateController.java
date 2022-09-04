package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RestTemplateService;

@RestController
public class RestTemplateController {
	
	@Autowired
	private RestTemplateService service;
	
	@PostMapping("/call")
	public ResponseEntity<String> getMsg(){
		return new ResponseEntity<String>(service.callTemplate(), HttpStatus.OK);
	}

}
