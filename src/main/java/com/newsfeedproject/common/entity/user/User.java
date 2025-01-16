package com.newsfeedproject.common.entity.user;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	/**
	 *        < 이하 BaseEntity에서 상속받을 요소들 >
	 *        datetime created_at "가입일" ==  "생성일"
	 *        datetime upated_at "수정일"
	 *        datetime deleted_at "탈퇴일" == "삭제일"
	 *        tinyint is_deleted "삭제 여부"
	 */

	@Comment("유저 식별자")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", columnDefinition = "BIGINT")
	private Long id;

	@Comment("유저명")
	@Column(
		name = "user_name",
		nullable = false
	)
	private String userName;

	@Comment("이메일")
	@Column(
		name = "email",
		nullable = false
	)
	private String email;

	@Comment("비밀번호")
	@Column(
		name = "password",
		nullable = false
	)
	private String password;

	// 아무것도 매개변수로 받지 않는 생성자
	protected User() {
	}

	public User(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}
}
