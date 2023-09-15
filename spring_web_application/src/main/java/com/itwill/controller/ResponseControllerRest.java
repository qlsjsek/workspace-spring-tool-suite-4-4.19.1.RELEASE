package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.dto.Guest;

@Controller
public class ResponseControllerRest {
	/************response text[html]*************/
	@ResponseBody
	@GetMapping(value = "/response_string",produces = "text/plain;charset=UTF-8")
	public String response_string() {
		return "hello string for javascript ajax request[한글]";
	}
	@ResponseBody
	@GetMapping(value = "/response_html",produces = "text/html;charset=UTF-8")
	public String response_html() {
		return "<h3>hello string for javascript ajax request[한글]</h3><hr>";
	}
	
	@ResponseBody
	@GetMapping(value="/response_xml",produces = "text/xml;charset=UTF-8")
	public Guest response_xml() {
	
		Guest guest=Guest.builder()
					.guest_no(1)
					.guest_name("KIM")
					.guest_email("guard@naver.com")
					.guest_content("컨텐트")
					.guest_homepage("홈페이지")
					.guest_title("타이틀")
					.guest_date("2023/12/25")
					.build();
		return guest;
	}
	@ResponseBody
	@GetMapping(value="/response_json",produces = "application/json;charset=UTF-8")
	public Guest response_json() {
		Guest guest=Guest.builder()
				.guest_no(1)
				.guest_name("KIM")
				.guest_email("guard@naver.com")
				.guest_content("컨텐트")
				.guest_homepage("홈페이지")
				.guest_title("타이틀")
				.guest_date("2023/12/25")
				.build();
		return guest;
	}
	
	
}





