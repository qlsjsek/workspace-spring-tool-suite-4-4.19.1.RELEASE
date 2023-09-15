package com.itwill.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloAnnotationController1 {
	public HelloAnnotationController1() {
		System.out.println("### HelloAnnotationController1() 생성자 호출");
	}
	@RequestMapping("/hello1")
	public String hello1(HttpServletRequest request) {
		request.setAttribute("msg", "HelloAnnotationController1 안녕");
		return "forward:/WEB-INF/views/hello1.jsp";
	}
	
}
