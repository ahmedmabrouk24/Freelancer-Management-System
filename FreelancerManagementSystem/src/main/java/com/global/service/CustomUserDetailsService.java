package com.global.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.global.entity.AppUser;
import com.global.entity.Freelancer;
import com.global.repository.FreelancerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private FreelancerRepository freelancerRepository;
	
	@Override
    public AppUser loadUserByUsername(String username) throws UsernameNotFoundException {
        Freelancer freelancer = freelancerRepository.findByEmail(username);

        if (freelancer == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        return new AppUser(freelancer);
    }

}
