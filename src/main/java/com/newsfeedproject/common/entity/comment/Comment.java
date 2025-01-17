package com.newsfeedproject.common.entity.comment;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.newsfeedproject.common.entity.post.Post;
import com.newsfeedproject.common.entity.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@AllArgsConstructor
@Table(name = "Comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;

	@JoinColumn(name = "contnet")
	private String content;

	@Column(name = "parent_comment_id")
	private Long parentCommentId; // 부모 댓글 추가!

	@CreatedDate
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	// 삭제에 대한 어노테이션이 필요한가?
	@Column(name = "deleted_at", nullable = false)
	private LocalDateTime deletedAt;

	// 기본 생성자
	public Comment() {

	}

	// 필요 부분 생성자 (인수 4)
	public Comment(String content, User user, Post post, Long parentId) {
		this.content = content;
		this.user = user;
		this.post = post;
		this.parentCommentId = parentId;
	}
}
