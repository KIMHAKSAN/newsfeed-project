package com.newsfeedproject.common.entity.friend;

import com.newsfeedproject.common.entity.user.User;
import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY) // 다대일 관계 설정
    @JoinColumn(name = "from_user_id", nullable = false) // 관계에서 외래 키로 설정
    // nullable = false, null을 쓸지 안 쓸지 말한다.
    private User fromUser;

    @ManyToOne(fetch = FetchType.LAZY)
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

}