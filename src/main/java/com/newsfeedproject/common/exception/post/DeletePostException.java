package com.newsfeedproject.common.exception.post;

import com.newsfeedproject.common.exception.BaseException;
import com.newsfeedproject.common.exception.ResponseCode;

public class DeletePostException extends BaseException {
	public DeletePostException() {
		super(ResponseCode.POST_IS_DELETE);
	}
}
