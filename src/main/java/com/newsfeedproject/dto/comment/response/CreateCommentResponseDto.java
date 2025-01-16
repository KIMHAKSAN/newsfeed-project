package com.newsfeedproject.dto.comment.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateCommentResponseDto {

	private Long id;
	private String userName;
	private String content;
	private LocalDateTime createdAt;

	public CreateCommentResponseDto(Long id, String content) {
	}
}

