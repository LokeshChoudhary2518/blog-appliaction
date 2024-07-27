package com.blog.blog_app_apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blog_app_apis.entities.Catagory;

public interface CatagoryRepo extends JpaRepository<Catagory, Integer> {
	
}
