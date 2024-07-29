package com.blog.blog_app_apis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.blog.blog_app_apis.payloads.ApiResponse;
import com.blog.blog_app_apis.payloads.PostDto;
import com.blog.blog_app_apis.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;
   // this is controllers
	@PostMapping("/user/{userId}/catagory/{catagoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer catagoryId) {
		PostDto createPost = this.postService.createPost(postDto, userId, catagoryId);
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}
	
	//get by user
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) 
	{
		List<PostDto> posts = this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	
	@GetMapping("/catagory/{catagoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCatagory(@PathVariable Integer catagoryId) 
	{
		List<PostDto> posts = this.postService.getPostByCatagory(catagoryId);
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPost()
	{
	   List<PostDto> allPost = this.postService.getAllPost();
	   
	   return new ResponseEntity<List<PostDto>>(allPost, HttpStatus.OK);
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto>getAllPost(@PathVariable Integer postId)
	{
	   PostDto singlePost = this.postService.getPostById(postId);
	   
	   return new ResponseEntity<PostDto>(singlePost, HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId)
	{
		this.postService.deletePost(postId);
		
		return new ApiResponse("Post is Sucessfully deleted !!", true);
	}
		
	
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId)
	{
		PostDto updatePost = this.postService.updatePost(postDto,  postId);
		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
	}

}


