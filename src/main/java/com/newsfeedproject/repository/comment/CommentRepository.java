package com.newsfeedproject.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newsfeedproject.common.entity.comment.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	Comment findById(long id);  // 하나의 댓글의 아이디값을 찾음
}

