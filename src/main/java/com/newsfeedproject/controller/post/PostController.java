package com.newsfeedproject.controller.post;

import java.util.List;

import com.newsfeedproject.dto.post.request.CreatePostRequestDto;
import com.newsfeedproject.dto.post.request.UpdatePostRequestDto;
import com.newsfeedproject.dto.post.response.CreatePostResponseDto;
import com.newsfeedproject.dto.post.response.FindPostResponseDto;
import com.newsfeedproject.dto.post.response.DeletePostResponseDto;
import com.newsfeedproject.dto.post.response.UpdatePostResponseDto;
import com.newsfeedproject.service.post.PostService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	// 게시글 생성 API
	@PostMapping
	public ResponseEntity<CreatePostResponseDto> createPostAPI(Long id,
		@RequestBody CreatePostRequestDto createPostRequestdto) {
		//세션 추가해야 함
		CreatePostResponseDto createPostResponseDto = postService.createPost(id, createPostRequestdto);
		return ResponseEntity.ok(createPostResponseDto);
	}

	//게시글 조회 API
	@GetMapping("/{post_id}")
	public ResponseEntity<FindPostResponseDto> findPostByIdAPI(
		@PathVariable(name = "post_id") Long id) {
		//세션 추가해야 함
		FindPostResponseDto findPostById = postService.findPostById(id);
		return ResponseEntity.ok(findPostById);
	}

	//게시물 전체 조회 API
	@GetMapping
	public List<FindPostResponseDto> FindALlPostAPI() {

		return postService.findAllPost();
	}

	//게시물 수정 API
	@PatchMapping("/{post_id}")
	public ResponseEntity<UpdatePostResponseDto> updatePostAPI(
		@PathVariable(name = "post_id") Long postId, @RequestBody UpdatePostRequestDto updatePostRequestDto) {
		//세션 추가해야 함
		UpdatePostResponseDto updatePost = postService.updatePost(postId, updatePostRequestDto);
		return ResponseEntity.ok(updatePost);
	}

	//게시물 삭제 API
	@DeleteMapping("/{post_id}")
	public ResponseEntity<DeletePostResponseDto> deletePostAPI(
		@PathVariable(name = "post_id") Long id) {
		//세션 추가해야 함
		DeletePostResponseDto deletePostResponseDto = postService.deletePost(id);
		return ResponseEntity.ok(deletePostResponseDto);
	}
}
