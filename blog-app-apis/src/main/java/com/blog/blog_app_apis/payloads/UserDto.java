package com.blog.blog_app_apis.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	private int id;
    
	@NotEmpty
	@Size(min =4, message = "Username must be 3 or more character !!")
	private String name;
    
	@Email(message ="Email address is not valid !!")
	private String email;
	
	@NotNull
	@Size(min =3, max=10, message ="Password must be min of 3 and max of 10 chars !!")
	private String password;
	
	@NotEmpty
	private String about;

}
