package com.blog.blog_app_apis.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CatagoryDto {
	
	
	private Integer catagoryId;
	
	@NotBlank
	@Size(min=4, message = "Min Size Of Catagory title is 4")
	private String catagoryTitle;
	
	@NotBlank
	@Size(min = 10, message ="Min size of discription is 10")
	private String catagoryDescription;
	public CatagoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CatagoryDto(Integer catagoryId, String catagoryTitle, String catagoryDescription) {
		super();
		this.catagoryId = catagoryId;
		this.catagoryTitle = catagoryTitle;
		this.catagoryDescription = catagoryDescription;
	}
	public Integer getCatagoryId() {
		return catagoryId;
	}
	public void setCatagoryId(Integer catagoryId) {
		this.catagoryId = catagoryId;
	}
	public String getCatagoryTitle() {
		return catagoryTitle;
	}
	public void setCatagoryTitle(String catagoryTitle) {
		this.catagoryTitle = catagoryTitle;
	}
	public String getCatagoryDescription() {
		return catagoryDescription;
	}
	public void setCatagoryDescription(String catagoryDescription) {
		this.catagoryDescription = catagoryDescription;
	}

}
