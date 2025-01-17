package com.newsfeedproject.dto.user.request;

import lombok.Getter;

@Getter
public class LoginUserRequestDto {
	private String email;
	private String password;

	protected LoginUserRequestDto() {}

	public LoginUserRequestDto(String email, String password) {
		this.email = email;
		this.password = password;
	}

}
