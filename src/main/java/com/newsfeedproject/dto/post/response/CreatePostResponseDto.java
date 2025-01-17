package com.newsfeedproject.dto.post.response;

import java.time.LocalDateTime;

import com.newsfeedproject.common.entity.post.Post;

import lombok.Getter;

@Getter
public class CreatePostResponseDto {

	private String message;
	private String content;
	private LocalDateTime createdAt;

	public CreatePostResponseDto(String message, Post savePost) {
		this.message = message;
		this.content = savePost.getContent();
		this.createdAt = savePost.getCreatedAt();
	}

}
