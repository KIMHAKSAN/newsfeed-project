package com.newsfeedproject.dto.post.response;

import java.time.LocalDateTime;

import com.newsfeedproject.common.entity.post.Post;

import lombok.Getter;

@Getter
public class DeletePostResponseDto {

	private String message;
	private LocalDateTime deletedAt;

	public DeletePostResponseDto(String message, Post post) {
		this.message = message;
		this.deletedAt = post.getDeletedAt();
	}
}
