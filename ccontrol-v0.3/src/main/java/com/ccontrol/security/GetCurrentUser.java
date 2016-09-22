package com.ccontrol.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;




public class GetCurrentUser {
	

	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	org.springframework.security.core.userdetails.User cu = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
	
	public String getUserName(){
		
		return cu.getUsername();
	}
}
