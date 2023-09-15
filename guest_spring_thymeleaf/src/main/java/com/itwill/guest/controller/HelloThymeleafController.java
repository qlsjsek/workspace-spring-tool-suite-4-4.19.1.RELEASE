package com.itwill.guest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloThymeleafController {
	@RequestMapping("/hello_thymeleaf")
	public String hello() {
		return "hello_thymeleaf";
	}
}