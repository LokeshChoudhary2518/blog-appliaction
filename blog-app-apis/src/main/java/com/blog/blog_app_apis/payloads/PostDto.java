package com.blog.blog_app_apis.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PostDto {
	
	private Integer postId;

	private String title;

	private String content;
	
	

	

	public PostDto(Integer postId, String title, String content, Set<CommentDto> comments, String imageName,
			Date addedDate, CatagoryDto catagory, UserDto user) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.comments = comments;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.catagory = catagory;
		this.user = user;
	}

	public Set<CommentDto> getComments() {
		return comments;
	}

	public void setComments(Set<CommentDto> comments) {
		this.comments = comments;
	}



	private Set<CommentDto> comments = new HashSet<>();

	public PostDto(Integer postId, String title, String content, String imageName, Date addedDate, CatagoryDto catagory,
			UserDto user) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.catagory = catagory;
		this.user = user;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	private String imageName;

	private Date addedDate;

	private CatagoryDto catagory;

	private UserDto user;

//	public PostDto(String title, String content, String imageName, Date addedDate, CatagoryDto catagory, UserDto user) {
//		super();
//		this.title = title;
//		this.content = content;
//		this.imageName = imageName;
//		this.addedDate = addedDate;
//		this.catagory = catagory;
//		this.user = user;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public CatagoryDto getCatagory() {
		return catagory;
	}

	public void setCatagory(CatagoryDto catagory) {
		this.catagory = catagory;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
