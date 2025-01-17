package com.newsfeedproject.common.exception.comment;

import com.newsfeedproject.common.exception.BaseException;
import com.newsfeedproject.common.exception.ResponseCode;

public class CommentNotFoundException extends BaseException {
	public CommentNotFoundException() {
		super(ResponseCode.COMMENT_NOT_FOUND);
	}
}
