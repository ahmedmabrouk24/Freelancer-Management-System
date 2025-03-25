package com.global.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.entity.Freelancer;
import com.global.service.FreelancerService;

@RestController
@RequestMapping("/api/user")
public class FreelancerController {

    @Autowired
    private FreelancerService freelancerService;

    @PostMapping("/register")
    public ResponseEntity<?> registerFreelancer(@RequestBody Freelancer freelancer) {
    	freelancerService.registerFreelancer(freelancer);
        return ResponseEntity.ok("User registered successfully!");
    }
}

