package com.newsfeedproject.dto.comment.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateCommentRequestDto {

	private String userName;
	private Long parentCommentId; // 부모댓글 생성 -> nullable
	private String content;

	public Long getUserId() {
		return Long.valueOf(userName);
	}

}
