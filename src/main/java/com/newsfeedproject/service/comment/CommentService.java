package com.newsfeedproject.service.comment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.newsfeedproject.common.entity.comment.Comment;
import com.newsfeedproject.common.entity.post.Post;
import com.newsfeedproject.common.entity.user.User;
import com.newsfeedproject.common.exception.comment.CommentNotFoundException;
import com.newsfeedproject.common.exception.comment.PostNotFoundException;
import com.newsfeedproject.dto.comment.request.CreateCommentRequestDto;
import com.newsfeedproject.dto.comment.request.UpdateCommentRequestDto;
import com.newsfeedproject.dto.comment.response.CreateCommentResponseDto;
import com.newsfeedproject.dto.comment.response.UpdateCommentResponseDto;
import com.newsfeedproject.repository.comment.CommentRepository;
import com.newsfeedproject.repository.post.PostRepository;
import com.newsfeedproject.repository.user.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	private final PostRepository postRepository;

	// 댓글 생성 메서드
	public CreateCommentResponseDto createComment(Long postId, CreateCommentRequestDto createRequestDto) {

		// 피드(게시물)와 작성자 정보 조회
		Post post = postRepository.findPostByPostId(postId)
			.orElseThrow(() -> new PostNotFoundException()); // 예외처리 추가
		User user = userRepository.findById(createRequestDto.getUserId())
			.orElseThrow(() -> new EntityNotFoundException("유저를 찾을 수 없습니다."));

		// 부모 아이디의 존재여부 검증 로직
		if (createRequestDto.getParentCommentId() != null) {
			boolean existsById = commentRepository.existsById(createRequestDto.getParentCommentId());
			if (!existsById) {
				throw new CommentNotFoundException(); // 같은 코드 if(existById == false) -> 예외처리 추가
			}
		}

		// 댓글 엔티티 생성
		Comment comment = new Comment(
			createRequestDto.getContent(),
			user,
			post,
			createRequestDto.getParentCommentId());

		// 데이터베이스에 댓글 저장
		Comment savedComment = commentRepository.save(comment);

		// 저장된 댓글 정보를 CreateCommentResponseDto로 변환하여 반환
		return new CreateCommentResponseDto(
			savedComment.getId(),
			savedComment.getContent()
		);
	}

	public List<CreateCommentResponseDto> findAllComments(Long PostId) {
		return new ArrayList<>();
	}

	public UpdateCommentResponseDto updateComment(Long commentId, UpdateCommentRequestDto updateCommentRequestDto) {
		return new UpdateCommentResponseDto(commentRepository.findById(commentId));
	}

	public void deleteComment(Long commentId) {

		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new CommentNotFoundException()); // 예외처리 추가

		commentRepository.delete(comment);

	}

}


