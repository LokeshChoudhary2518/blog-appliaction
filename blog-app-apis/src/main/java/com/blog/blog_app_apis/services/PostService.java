package com.blog.blog_app_apis.services;

import java.util.List;

import com.blog.blog_app_apis.entities.Catagory;
import com.blog.blog_app_apis.entities.Post;
import com.blog.blog_app_apis.entities.User;
import com.blog.blog_app_apis.payloads.PostDto;

public interface PostService {

	PostDto createPost(PostDto postDto, Integer userId, Integer catagoryId);

	Post updatePost(PostDto postDto, Integer postId);

	void deletePost(Integer postId);

	List<Post> getAllPost();

	Post getPostById(Integer postId);

	List<Catagory> getPostByCatagory(Integer catagoryId);

	List<User> getPostByUser(Integer userId);

	List<Post> searchPosts(String keyword);

}
