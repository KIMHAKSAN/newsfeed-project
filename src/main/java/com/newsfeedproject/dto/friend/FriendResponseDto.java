package com.newsfeedproject.dto.friend;

import com.newsfeedproject.common.entity.friend.Friend;
import com.newsfeedproject.common.entity.friend.FriendStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FriendResponseDto {
	private Long id; // Friend 엔티티의 ID
	private Long fromUserId; // 요청한 유저의 ID
	private Long toUserId;   // 친구 요청받은 유저의 ID
	private FriendStatus status; // 친구 상태

	public FriendResponseDto(Friend friend) {
		this.id = friend.getId();
		this.status = friend.getStatus();

		this.fromUserId = friend.getFromUser().getId();
		this.toUserId = friend.getToUser().getId();

	}
}

