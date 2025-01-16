package com.newsfeedproject.common.entity.friend;

import com.newsfeedproject.common.entity.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "friend")
public class Friend {
	// 속성
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// JPA에서 엔티티의 기본 키(primary key)를 자동으로 생성하기 위한 설정
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER) // EAGER 로딩으로 변경
	@JoinColumn(name = "from_user_id", nullable = false)
	private User fromUser;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "to_user_id", nullable = false)
	private User toUser;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private FriendStatus status;

	// 생성자
	public Friend(User fromUser, User toUser, FriendStatus status) {
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.status = status;
	}

	// 친구 상태 변경 메서드
	public void updateStatus(FriendStatus newStatus) {
		this.status = newStatus;
	}
}