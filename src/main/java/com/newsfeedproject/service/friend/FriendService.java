package com.newsfeedproject.service.friend;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsfeedproject.common.entity.friend.Friend;
import com.newsfeedproject.common.entity.friend.FriendStatus;
import com.newsfeedproject.common.entity.user.User;
import com.newsfeedproject.dto.friend.FriendRequestDto;
import com.newsfeedproject.dto.friend.FriendResponseDto;
import com.newsfeedproject.repository.friend.FriendRepository;
import com.newsfeedproject.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FriendService {

	private final UserRepository userRepository;
	private final FriendRepository friendRepository;

	// 친구 신청 POST /api/friends/{fromuserId}/{tofriendId)
	@Transactional
	public Friend createFriendService(FriendRequestDto requestDto) {
		// fromUserId로 User 조회
		User fromUser = userRepository.findById(requestDto.getFromUserId())
			.orElseThrow(() -> new IllegalArgumentException("From user not found"));

		// toUserId로 User 조회
		User toUser = userRepository.findById(requestDto.getToUserId())
			.orElseThrow(() -> new IllegalArgumentException("To user not found"));

		// Friend 객체 생성/{fromuserId}/{tofriendId)
		Friend friend = new Friend(fromUser, toUser, FriendStatus.FRIEND_PENDING);

		// Friend 저장
		friend = friendRepository.save(friend);

		// 즉시 로딩하여 Friend의 fromUser와 toUser를 사용할 수 있도록 보장
		return friend;
	}

	// 친구 수락 PATCH /api/friends/{tofriendId)/{fromuserId}
	@Transactional
	public void AcceptFriendStatusService(Long fromUserId, Long toUserId) {
		// fromUserId와 toUserId로 친구 관계 찾기
		Friend friend = friendRepository.findByFromUserIdAndToUserId(fromUserId, toUserId)
			.orElseThrow(() -> new IllegalArgumentException("Friend relationship not found"));
		// 친구 수락하여 저장
		friend.updateStatus(FriendStatus.FRIEND_ACCEPT);

		friendRepository.save(friend);
	}

	// 친구 거절 PATCH /api/friends//{fromuserId}/{tofriendId)
	@Transactional
	public void DeclineFriendStatusService(Long fromUserId, Long toUserId) {

		Friend friend = friendRepository.findByFromUserIdAndToUserId(fromUserId, toUserId)
			.orElseThrow(() -> new IllegalArgumentException("Friend relationship not found"));

		friend.updateStatus(FriendStatus.FRIEND_DECLINE);

		friendRepository.save(friend);
	}

	// 친구 삭제 DELETE /api/delete/friends/{tofriendId)/{fromuserId}
	@Transactional
	public void deleteFriend(Long id) {
		friendRepository.deleteById(id);
	}

	// 친구 단건 조회
	public FriendResponseDto findFriendById(Long id, Long userId) {
		Friend friend = friendRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Friend not found"));

		// 사용자 구분 및 출력 데이터 구성
		if (friend.getFromUser().getId().equals(userId)) {
			return new FriendResponseDto(
				friend.getId(),
				friend.getToUser().getId(),
				friend.getToUser().getUserName(),
				friend.getStatus()
			);
		} else if (friend.getToUser().getId().equals(userId)) {
			return new FriendResponseDto(
				friend.getId(),
				friend.getFromUser().getId(),
				friend.getFromUser().getUserName(),
				friend.getStatus()
			);
		} else {
			throw new IllegalArgumentException("Invalid user for this friend");
		}
	}

	// 친구 다건 조회
	public List<FriendResponseDto> findAllFriendsByUserId(Long userId) {
		List<Friend> friends = friendRepository.findAllByFromUserIdOrToUserId(userId, userId);

		return friends.stream().map(friend -> {
			if (friend.getFromUser().getId().equals(userId)) {
				return new FriendResponseDto(
					friend.getId(),
					friend.getToUser().getId(),
					friend.getToUser().getUserName(),
					friend.getStatus()
				);
			} else {
				return new FriendResponseDto(
					friend.getId(),
					friend.getFromUser().getId(),
					friend.getFromUser().getUserName(),
					friend.getStatus()
				);
			}
		}).toList();
	}
}
