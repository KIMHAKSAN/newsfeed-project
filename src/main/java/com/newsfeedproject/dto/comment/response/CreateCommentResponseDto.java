package com.newsfeedproject.dto.comment.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateCommentResponseDto {

	private Long id;
	private String content;
	private String username;
	private LocalDateTime createdAt;

	public CreateCommentResponseDto(Long id, String content) {
	}
}

