package com.global.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.global.entity.Freelancer;
import com.global.repository.FreelancerRepository;

@Service
public class FreelancerService {

    @Autowired
    private FreelancerRepository freelancerRepository;

    public void registerFreelancer(Freelancer freelancer) {
    	freelancer.setPassword(new BCryptPasswordEncoder().encode(freelancer.getPassword()));  
    	freelancerRepository.save(freelancer);
    }
}