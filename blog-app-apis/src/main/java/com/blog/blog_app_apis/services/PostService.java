package com.blog.blog_app_apis.services;

import java.util.List;

import com.blog.blog_app_apis.payloads.CatagoryDto;
import com.blog.blog_app_apis.payloads.PostDto;
import com.blog.blog_app_apis.payloads.UserDto;

public interface PostService {

	PostDto createPost(PostDto postDto, Integer userId, Integer catagoryId);

	PostDto updatePost(PostDto postDto, Integer postId);

	void deletePost(Integer postId);

	List<PostDto> getAllPost();

	PostDto getPostById(Integer postId);

	List<PostDto> getPostByCatagory(Integer catagoryId);

	List<PostDto> getPostByUser(Integer userId);

	List<PostDto> searchPosts(String keyword);

}
