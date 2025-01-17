package com.newsfeedproject.controller.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsfeedproject.common.entity.user.User;
import com.newsfeedproject.common.session.SessionConst;
import com.newsfeedproject.dto.user.request.CreateUserRequestDto;
import com.newsfeedproject.dto.user.request.LoginUserRequestDto;
import com.newsfeedproject.dto.user.response.CreateUserResponseDto;
import com.newsfeedproject.dto.user.response.LoginUserResponseDto;
import com.newsfeedproject.service.user.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	// 회원가입
	@PostMapping("/signup")
	public ResponseEntity<CreateUserResponseDto> userSignupAPI(@RequestBody CreateUserRequestDto dto) {
		return new ResponseEntity<>(userService.userSignupService(dto),HttpStatus.CREATED);
	}

	// 회원 탈퇴

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<LoginUserResponseDto> userLogin(
		@RequestBody LoginUserRequestDto dto,
		HttpServletRequest request
		) {
		User loginUser = userService.loginUserService(dto);

		// 로그인 성공 처리
		HttpSession session = request.getSession();
		session.setAttribute(SessionConst.LOGIN_USER_NAME, loginUser.getUserName());
		session.setAttribute(SessionConst.LOGIN_USER_ID, loginUser.getId());
		session.setAttribute(SessionConst.USER_STATUS, loginUser.getStatus());

		return new ResponseEntity<>(new LoginUserResponseDto(), HttpStatus.OK);
	}

	// 로그아웃(todo 세션 사용해야 함. invalidate() 사용)
	// @PostMapping("/logout")
	// public

	// 회원 다건 조회
}
