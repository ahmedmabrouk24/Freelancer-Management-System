package com.global.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.global.entity.BaseUser;
import com.global.entity.Freelancer;
import com.global.entity.Project;
import com.global.repository.FreelancerRepository;
import com.global.repository.ProjectRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private FreelancerRepository freelancerRepository;
    
    @Transactional
    public void addProject(Project project) {
    	projectRepository.addProject(project);
    }

    public List<Project> searchProjects(String query) {

        String email = ((BaseUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail();
        Freelancer freelancer = freelancerRepository.findByEmail(email);
        Long freelancerId = freelancer.getId();
        
        String formattedQuery = query.trim().replace("\"", "").replace(" ", " & ");
        
        return projectRepository.searchProjectsByQuery(formattedQuery, freelancerId);
    }
}