package com.newsfeedproject.common.entity.post;

import com.newsfeedproject.common.entity.BaseEntity;
import com.newsfeedproject.common.entity.user.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "POST")
@NoArgsConstructor
public class Post extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;

	private String content;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Post(String content) {
		this.content = content;
	}


}
