package com.newsfeedproject.dto.user.response;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class FindUserResponseDto {

	private final String email;
	private final LocalDateTime createdAt;

	public FindUserResponseDto(String email, LocalDateTime createdAt) {
		this.email = email;
		this.createdAt = createdAt;
	}
}
