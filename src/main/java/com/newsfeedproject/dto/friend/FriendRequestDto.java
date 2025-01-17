package com.newsfeedproject.dto.friend;

import com.newsfeedproject.common.entity.friend.FriendStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class FriendRequestDto {
	private Long fromUserId; // 요청하는 유저의 ID
	private Long toUserId;   // 친구 요청받는 유저의 ID
	private FriendStatus status; // 친구 상태 (예: REQUESTED, ACCEPTED 등)
}
