package com.blog.blog_app_apis.payloads;

public class CommentDto {

	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CommentDto(int commentId, String content) {
		super();
		this.commentId = commentId;
		this.content = content;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private int commentId;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	private String content;

}
