package com.newsfeedproject.dto.post.response;

import java.time.LocalDateTime;

import com.newsfeedproject.common.entity.post.Post;

import lombok.Getter;

@Getter
public class UpdatePostResponseDto {

	private String message;
	private String content;
	private LocalDateTime updatedAt;

	public UpdatePostResponseDto(String message, Post post) {
		this.message = message;
		this.content = post.getContent();
		this.updatedAt = post.getUpdatedAt();
	}
}
