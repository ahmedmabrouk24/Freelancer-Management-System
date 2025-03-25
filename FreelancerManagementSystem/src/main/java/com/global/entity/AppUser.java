package com.global.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AppUser extends BaseUser implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		return super.getEmail();
	}
	
	public AppUser(Freelancer freelancer) {
		super();
		this.id = freelancer.getId();
		this.name = freelancer.getName();
		this.password = freelancer.getPassword();
		this.email = freelancer.getEmail();
	}

}
