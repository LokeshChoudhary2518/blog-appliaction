package com.blog.blog_app_apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blog_app_apis.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer> {

}
