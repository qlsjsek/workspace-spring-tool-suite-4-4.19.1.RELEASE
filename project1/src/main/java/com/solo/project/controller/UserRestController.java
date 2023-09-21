package com.solo.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solo.project.user.UserService;

@RestController
public class UserRestController {
	@Autowired
	private UserService userService;
}
