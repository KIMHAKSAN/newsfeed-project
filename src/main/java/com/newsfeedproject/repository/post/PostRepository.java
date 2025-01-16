package com.newsfeedproject.repository.post;

import java.util.Optional;

import com.newsfeedproject.common.entity.post.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

	Optional<Post> findPostByPostId(Long postId);
}
