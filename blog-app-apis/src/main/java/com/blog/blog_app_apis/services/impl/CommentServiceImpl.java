package com.blog.blog_app_apis.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blog_app_apis.entities.Comment;
import com.blog.blog_app_apis.entities.Post;
import com.blog.blog_app_apis.exeption.ResourceNotFoundException;
import com.blog.blog_app_apis.payloads.CommentDto;
import com.blog.blog_app_apis.repository.CommentRepo;
import com.blog.blog_app_apis.repository.PostRepo;
import com.blog.blog_app_apis.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private PostRepo postRepo;
     
	@Autowired
	private ModelMapper modelMapper;
	



	@Override
	 public CommentDto createComment(CommentDto commentDto, Integer postId) {
        // Retrieve the Post entity
        Post post = this.postRepo.findById(postId)
            .orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));

        // Map CommentDto to Comment entity
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);

        // Save the Comment entity
        Comment savedComment = this.commentRepo.save(comment);

        // Map saved Comment entity to CommentDto
        return this.modelMapper.map(savedComment, CommentDto.class);
    }

	@Override
	public void deleteComment(Integer commentId) {
           Comment com = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment","commentId", commentId));
           this.commentRepo.delete(com);
           
	}

}
