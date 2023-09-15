package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.exception.BusinessException1;
import com.itwill.exception.BusinessException2;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class LocalExceptionController {
	@GetMapping("/business1")
	public String business_method1() throws BusinessException1 {
		boolean b=true;
		if(b) {
			throw new BusinessException1("업무예외1");
		}
		return "forward:/WEB-INF/views/business_result1.jsp";
	}
	@GetMapping("/business2")
	public String business_method2() throws BusinessException2 {
		boolean b=true;
		if(b) {
			throw new BusinessException2("업무예외2");
		}
		return "forward:/WEB-INF/views/business_result2.jsp";
	}
	@GetMapping("/business3")
	public String business_method3() {
		String name = null;
		int length = name.length();
		return "forward:/WEB-INF/views/business_result2.jsp";
	}

	/**************예외처리************************/
	@ExceptionHandler(BusinessException1.class)
	public String handle_business_exception1(BusinessException1 e,
											 Model model) {
		model.addAttribute("error_msg", e.getMessage());
		return "forward:/WEB-INF/views/business_error_result.jsp";
	}
	@ExceptionHandler(BusinessException2.class)
	public String handle_business_exception2(BusinessException2 e,
			Model model) {
		model.addAttribute("error_msg", e.getMessage());
		return "forward:/WEB-INF/views/business_error_result.jsp";
	}
	/*
	@ExceptionHandler(Exception.class)
	public String handle_exception(Exception e,Model model) {
		model.addAttribute("error_msg", e.getMessage());
		return "forward:/WEB-INF/views/business_error_result.jsp";
	}
	*/
	
	
	
	
	
	
	
}
