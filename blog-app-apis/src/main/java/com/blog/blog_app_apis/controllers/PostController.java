package com.blog.blog_app_apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog_app_apis.payloads.PostDto;
import com.blog.blog_app_apis.services.PostService;

@RestController
@RequestMapping("/")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("users/{userId}/catagories/{catagoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer catagoryId) {
		PostDto createPost = this.postService.createPost(postDto, userId, catagoryId);
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}

}
