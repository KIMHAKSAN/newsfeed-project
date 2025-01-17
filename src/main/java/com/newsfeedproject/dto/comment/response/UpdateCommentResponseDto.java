package com.newsfeedproject.dto.comment.response;

import java.util.Optional;

import javax.swing.text.AbstractDocument;

import com.newsfeedproject.common.entity.comment.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateCommentResponseDto {

	private Long id;
	private AbstractDocument.Content content;

	public UpdateCommentResponseDto(Optional<Comment> byUserId) {

	}
}
