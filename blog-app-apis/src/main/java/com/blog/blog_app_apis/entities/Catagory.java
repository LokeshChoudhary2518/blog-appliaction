package com.blog.blog_app_apis.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="catagory")
public class Catagory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer catagoryId;
	
	@Column(name = "title", length= 100, nullable= true)
	private String catagoryTitle;
	
	@Column(name = "discription")
	private String catagoryDescription;
	
	@OneToMany(mappedBy= "catagory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> post = new ArrayList<>();

	public Catagory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Catagory(Integer catagoryId, String catagoryTitle, String catagoryDescription) {
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
