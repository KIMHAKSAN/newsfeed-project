package com.newsfeedproject.dto.user.request;

import lombok.Getter;

@Getter
public class CreateUserRequestDto {

	private String email;
	private String userName;
	private String password;
	private String reEnterPassword;

	public CreateUserRequestDto(String email, String userName, String password, String reEnterPassword) {
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.reEnterPassword = reEnterPassword;
	}

}