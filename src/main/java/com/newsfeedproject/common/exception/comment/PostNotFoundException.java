package com.newsfeedproject.common.exception.comment;

import com.newsfeedproject.common.exception.BaseException;
import com.newsfeedproject.common.exception.ResponseCode;

public class PostNotFoundException extends BaseException {
	public PostNotFoundException() {
		super(ResponseCode.POST_NOT_FOUND);
	}
}
