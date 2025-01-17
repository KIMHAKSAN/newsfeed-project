package com.newsfeedproject.dto.post.response;

import com.newsfeedproject.common.entity.post.Post;

import lombok.Getter;

@Getter
public class FindPostResponseDto {

	private String content;

	public FindPostResponseDto(Post post) {
		this.content = post.getContent();
	}

	public static FindPostResponseDto getPostDetails(Post post) {
		return new FindPostResponseDto(post);
	}
}
