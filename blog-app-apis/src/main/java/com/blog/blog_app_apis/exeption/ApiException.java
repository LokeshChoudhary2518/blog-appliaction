package com.blog.blog_app_apis.exeption;

public class ApiException extends RuntimeException {

	public ApiException(String message) {
		super(message);
	}

	public ApiException() {
		super();
	}
	
	

}
