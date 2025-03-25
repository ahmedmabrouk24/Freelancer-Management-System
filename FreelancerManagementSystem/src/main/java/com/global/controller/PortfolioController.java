package com.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.entity.Project;
import com.global.service.ProjectService;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/add")
    public ResponseEntity<?> addProject(@RequestBody Project project) {
        projectService.addProject(project);
        return ResponseEntity.ok("Project added successfully!");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Project>> searchProjects(@RequestParam("query") String query) {
        List<Project> projects = projectService.searchProjects(query);
        return ResponseEntity.ok(projects);
    }
}
