package com.blog.blog_app_apis.services;

import java.util.List;

import com.blog.blog_app_apis.payloads.PostDto;
import com.blog.blog_app_apis.payloads.PostResponse;

public interface PostService {

	PostDto createPost(PostDto postDto, Integer userId, Integer catagoryId);

	PostDto updatePost(PostDto postDto, Integer postId);

	void deletePost(Integer postId);
	
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sorDir);

	PostDto getPostById(Integer postId);

	List<PostDto> getPostByCatagory(Integer catagoryId);

	List<PostDto> getPostByUser(Integer userId);

	List<PostDto> searchPosts(String keywords);

}
