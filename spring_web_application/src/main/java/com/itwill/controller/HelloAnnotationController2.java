package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloAnnotationController2 {
	public HelloAnnotationController2() {
		System.out.println("### HelloAnnotationController2() 생성자 호출");
	}
	@RequestMapping("/hello2")
	public String hello2(HttpServletRequest request) {
		request.setAttribute("msg", "HelloAnnotationController2 안녕");
		return "forward:/WEB-INF/views/hello2.jsp";
	}
	
}
