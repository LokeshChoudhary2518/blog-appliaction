package com.blog.blog_app_apis.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blog.blog_app_apis.entities.Catagory;
import com.blog.blog_app_apis.entities.Post;
import com.blog.blog_app_apis.entities.User;
import com.blog.blog_app_apis.exeption.ResourceNotFoundException;
import com.blog.blog_app_apis.payloads.PostDto;
import com.blog.blog_app_apis.payloads.PostResponse;
import com.blog.blog_app_apis.repository.CatagoryRepo;
import com.blog.blog_app_apis.repository.PostRepo;
import com.blog.blog_app_apis.repository.UserRepo;
import com.blog.blog_app_apis.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CatagoryRepo catagoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer catagoryId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User id", userId));

		Catagory catagory = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Catagory", "catagory id", catagoryId));

		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCatagory(catagory);

		Post newPost = this.postRepo.save(post);

		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post","post id", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		
		Post updatedPost = this.postRepo.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
        this.postRepo.delete(post);
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		
//		int pageSize=5;
//		int pageNumber=1;
		
		Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
		
		Page<Post> pagePost = this.postRepo.findAll(p);
		
		List<Post> allPosts = pagePost.getContent();
		
		
		List<PostDto> postDto = allPosts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDto);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		
		return postResponse;
		
	}
		
////		int pageNumber=1;
//		
////		Pageable p = PageRequest.of(pageNumber, pageSize);
//		
////		Page<Post> pagePost = this.postRepo.findAll(p);
////		List<Post> allPosts = paggetSize()ePost.getContent();
//		
////		List<Catagory> catagories = this.catagoryRepo.findAll();
////		List<CatagoryDto> catDto = catagories.stream().map((cat)-> this.modelMapper.map(cat, CatagoryDto.class)).collect(Collectors.toList());
////		return catDto;
////	}
////		
//		List<Post> allPost = this.postRepo.findAll();
//		List<PostDto> postDto = allPost.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
//				.collect(Collectors.toList());
//
//		return postDto;
//	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "post id", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCatagory(Integer catagoryId) {

		Catagory cat = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Catagory", "catagoryId", catagoryId));

		List<Post> posts = this.postRepo.findByCatagory(cat);

		List<PostDto> postDtos = posts.stream().map(post -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());

		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		List<Post> posts = this.postRepo.findAllByUser(user);
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());

		return postDtos;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
//		
//		 this.
//		 List<Post> posts = this.postRepo.findByTitleContainingOrContentContaining(keyword, keyword);
//	        return posts.stream()
//	                    .map(this::convertToDto)
//	                    .collect(Collectors.toList());
		return null;
	    }
		
	}

