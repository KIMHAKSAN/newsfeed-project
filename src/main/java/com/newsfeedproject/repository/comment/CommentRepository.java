package com.newsfeedproject.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsfeedproject.common.entity.comment.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	Comment findById(long id);  // 하나의 댓글의 아이디값을 찾음
}

