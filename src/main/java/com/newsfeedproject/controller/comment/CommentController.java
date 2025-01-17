package com.newsfeedproject.controller.comment;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsfeedproject.dto.comment.request.CreateCommentRequestDto;
import com.newsfeedproject.dto.comment.request.UpdateCommentRequestDto;
import com.newsfeedproject.dto.comment.response.CreateCommentResponseDto;
import com.newsfeedproject.dto.comment.response.UpdateCommentResponseDto;
import com.newsfeedproject.service.comment.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts/{post_id}//comments")
public class CommentController {

	// 속성
	private final CommentService commentService;

	// 생성자 -> 어노테이션 사용

	// 기능
	@PostMapping // 댓글 생성
	public ResponseEntity<CreateCommentResponseDto> createComment(
		@PathVariable("post_id") Long postId, // (name="...")로 적으면 더 빡세게 적을 수 있다!
		@RequestBody CreateCommentRequestDto createRequestDto
	) {
		CreateCommentResponseDto createdComment = commentService.createComment(postId, createRequestDto);
		return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
	}

	@GetMapping // 댓글(대댓글 포함) 다건 조회
	public ResponseEntity<List<CreateCommentResponseDto>> findAllComments(
		@PathVariable("post_id") Long postId
	) {
		List<CreateCommentResponseDto> createCommentResponseDtoList = commentService.findAllComments(postId);
		return new ResponseEntity<>(createCommentResponseDtoList, HttpStatus.OK);
	}

	// @GetMapping
	// @PathVariable("/{comment_id}/replies") //findChildrenComments 로 로직을 짜보는 어떨지?

	@PutMapping("/{comment_id}") // 댓글 수정
	public ResponseEntity<UpdateCommentResponseDto> updateComment(
		@PathVariable("comment_id") Long commentId,
		@RequestBody UpdateCommentRequestDto updateCommentRequestDto
	) {
		UpdateCommentResponseDto updatedComment = commentService.updateComment(commentId, updateCommentRequestDto);
		return new ResponseEntity<>(updatedComment, HttpStatus.OK);
	}

	@DeleteMapping("/{comment_id}") // 댓글 삭제
	public ResponseEntity<Void> deleteComment( // void라고 쓰는게 맞나? DeletRe~Dto를 만들어서..메세지 출력할 수 있도록
		@PathVariable("comment_id") Long commentId
	) {
		commentService.deleteComment(commentId);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}




