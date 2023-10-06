package com.itwill.user.controller;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.itwill.user.exception.UnauthorizedUserException;

@RestControllerAdvice
public class UserRestControllerAdvice {
	@ExceptionHandler(UnauthorizedUserException.class)
	public ResponseEntity<Response> user_unauthorize_exception_handler(UnauthorizedUserException e) {
		Response response=new Response();
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setMessage(HttpStatus.UNAUTHORIZED.getReasonPhrase());
		return new ResponseEntity<Response>(response,headers,HttpStatus.UNAUTHORIZED);
	
	}
}
