package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Student;
import com.example.demo.rest.exception.handler.MyErrorHandler;

@Service
public class RestTemplateService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public String callTemplate() {
		//restTemplate.setErrorHandler(new MyErrorHandler());
		
		Student student = new Student();
		student.setName("");
		student.setEmail("abhishek@gmail.com");
		student.setMobileNo("98900");
		student.setAddress("Ramganj");
		
		HttpEntity<Student>request = new HttpEntity<Student>(student);
		String url =  "http://localhost:8084/save";
		ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.POST, request, String.class);
		
		System.out.println("RestTemplateService.callTemplate() Code: " + response.getStatusCodeValue());
		
		return "called";
		
	}

}
