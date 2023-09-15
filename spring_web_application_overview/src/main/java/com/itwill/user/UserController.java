package com.itwill.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	public UserController() {
		System.out.println("### UserController()기본생성자");
	}
	@GetMapping(value = "/user_list")
	public String list(HttpServletRequest request) {
		List<User> userList= userService.list();
		request.setAttribute("userList", userList);
		return "forward:/WEB-INF/views/user_list.jsp";
	}
	
}








