package com.example.demo.rest.exception.handler;

import org.springframework.http.HttpStatus;

public class RestCustomeError extends RuntimeException {
	private static final long serialVersionUID = 1L;

	String errorMessage;
	HttpStatus httpStatusCode;

	public RestCustomeError(String errorMessage, HttpStatus httpStatusCode) {
		super();
		this.errorMessage = errorMessage;
		this.httpStatusCode = httpStatusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public HttpStatus getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(HttpStatus httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

}
