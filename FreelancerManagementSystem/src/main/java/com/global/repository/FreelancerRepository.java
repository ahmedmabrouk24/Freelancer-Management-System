package com.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.entity.Freelancer;

public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {
	Freelancer findByEmail(String email);
}

