package com.newsfeedproject.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newsfeedproject.common.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/*
	 * 회원가입
	 * 유저가 입력한 이메일이 기가입한 이메일인지 확인
	 */
	Optional<User> findByEmail(String email);

}
