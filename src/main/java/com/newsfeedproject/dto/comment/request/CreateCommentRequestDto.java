package com.newsfeedproject.dto.comment.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateCommentRequestDto {

	private String userName;
	private String content;

	public Long getUserId() {
		return Long.valueOf(userName);
	}

}
