package com.newsfeedproject.controller.user;

import org.springframework.web.bind.annotation.RestController;

import com.newsfeedproject.service.user.UserService;

@RestController
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
}
