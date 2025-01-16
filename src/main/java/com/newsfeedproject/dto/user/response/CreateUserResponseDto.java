package com.newsfeedproject.dto.user.response;

import lombok.Getter;

@Getter
public class CreateUserResponseDto {

	private final String message;

	public CreateUserResponseDto() {
		this.message = "회원가입이 완료 되었습니다.";
	}

}