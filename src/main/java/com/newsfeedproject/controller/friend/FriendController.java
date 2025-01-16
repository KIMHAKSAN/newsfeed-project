package com.newsfeedproject.controller.friend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsfeedproject.common.entity.friend.Friend;
import com.newsfeedproject.dto.friend.FriendRequestDto;
import com.newsfeedproject.dto.friend.FriendResponseDto;
import com.newsfeedproject.service.friend.FriendService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/Friends")
@RequiredArgsConstructor
public class FriendController {

	private final FriendService friendService;

	@PostMapping
	public ResponseEntity<FriendResponseDto> createFriend(@RequestBody FriendRequestDto requestDto) {
		Friend friend = friendService.createFriendService(requestDto);
		FriendResponseDto responseDto = new FriendResponseDto(friend);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
	}
}
