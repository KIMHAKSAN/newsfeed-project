package com.newsfeedproject.controller.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsfeedproject.dto.user.request.CreateUserRequestDto;
import com.newsfeedproject.dto.user.response.CreateUserResponseDto;
import com.newsfeedproject.service.user.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	// 회원가입
	@PostMapping("/signup")
	public ResponseEntity<CreateUserResponseDto> userSignupAPI(CreateUserRequestDto dto) {
		return new ResponseEntity<>(userService.userSignupService(dto),HttpStatus.CREATED);
	}

	// 회원 탈퇴

	// 로그인
	// 로그아웃

	// 회원 다건 조회
}
