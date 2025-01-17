package com.newsfeedproject.common.entity.comment;

import com.newsfeedproject.common.entity.BaseEntity;
import com.newsfeedproject.common.entity.post.Post;
import com.newsfeedproject.common.entity.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 추가!
@Table(name = "Comment")
public class Comment extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY) // LAZY로 설정해야 합니다. 왜? 필요할 때에만 얻어와야 하기 때문이다.
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)//  LAZY로 설정해야 합니다. 왜? 필요할 때에만 얻어와야 하기 때문이다.
	@JoinColumn(name = "post_id")
	private Post post;

	@JoinColumn(name = "contnet")
	private String content;

	@Column(name = "parent_comment_id")
	private Long parentCommentId; // 부모 댓글 추가!

	// 필요 부분 생성자 (인수 4)
	public Comment(String content, User user, Post post, Long parentId) {
		this.content = content;
		this.user = user;
		this.post = post;
		this.parentCommentId = parentId;
	}
}
