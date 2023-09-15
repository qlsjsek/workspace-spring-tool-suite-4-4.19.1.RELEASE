package com.itwill.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.Order;

import jakarta.servlet.http.HttpSession;


public class SessionOrderController {

		
		public String session_order_process1() {
			
			return "";
		}
		
		public String session_order_process2() {
			
			return "";
		}
		
		public String session_order_process3() {
			
			return "";
		}
		
		public String session_order_process4() {
			
			return "";
		}
		
		public String session_order_process4(HttpSession session) {
			
			System.out.println(">>>>데이타베이스에 주문 insert[orderService.create(order)]");
			
			
			return "";
		}
		
	
}
