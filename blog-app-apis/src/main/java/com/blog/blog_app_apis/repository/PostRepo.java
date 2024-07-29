package com.blog.blog_app_apis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blog_app_apis.entities.Catagory;
import com.blog.blog_app_apis.entities.Post;
import com.blog.blog_app_apis.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
  List<Post> findAllByUser(User user);
  List<Post> findAllByCatagory(Catagory catagory);
  List<Post> findByCatagory(Catagory catagory);
  
}
