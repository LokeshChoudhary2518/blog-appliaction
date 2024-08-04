package com.blog.blog_app_apis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.blog_app_apis.entities.User;
import com.blog.blog_app_apis.exeption.ResourceNotFoundException;
import com.blog.blog_app_apis.repository.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;
	

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//loading user from database by username
		
		User user = this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User", "email: " +username, 0));
		
		return user;
		
		
		
		
		
		
		
//        // Example user details. Replace this with real data from your data source.
//        if ("user".equals(username)) {
//            List<GrantedAuthority> authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//            return new CustomUserDetails(username, "password", authorities, true, true, true, true);
//        } else if ("admin".equals(username)) {
//            List<GrantedAuthority> authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//            return new CustomUserDetails(username, "admin", authorities, true, true, true, true);
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
    }

}
