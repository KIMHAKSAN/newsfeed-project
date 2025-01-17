package com.newsfeedproject.dto.user.response;

import lombok.Getter;

@Getter
public class LoginUserResponseDto {
	private final String message;

	public LoginUserResponseDto() {
		this.message = "로그인되었습니다.";
	}
}
