package com.example.demo.rest.exception.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		DefaultResponseErrorHandler defaultHandler = new DefaultResponseErrorHandler();
		boolean error = defaultHandler.hasError(response);
		return error;
	}

	/*@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		if(response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
			// handl server error
		}else if(response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
			InputStream inputStream = response.getBody();
			
			String text = new BufferedReader(
					new InputStreamReader(inputStream,StandardCharsets.UTF_8))
					.lines().collect(Collectors.joining("\n"));
			System.out.println("Orignial Output: " + text);
			
			throw new RestCustomeError(text,response.getStatusCode());
		}
		
	}*/
	
	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
			InputStream inputStream = response.getBody();
			
			String text = new BufferedReader(
					new InputStreamReader(inputStream,StandardCharsets.UTF_8))
					.lines().collect(Collectors.joining("\n"));
			System.out.println("Orignial Output: " + text);
			
			throw new RestCustomeError(text,response.getStatusCode());
	}

	

}
