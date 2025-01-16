package com.newsfeedproject.repository.friend;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsfeedproject.common.entity.friend.Friend;

public interface FriendRepository extends JpaRepository<Friend, Long> {

	Optional<Friend> findById(Long id);

	List<Friend> findByFromUserId(Long fromUserId);

	List<Friend> findByToUserId(Long toUserId);
}
