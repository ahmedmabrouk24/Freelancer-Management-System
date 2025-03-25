package com.global.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.global.entity.BaseUser;
import com.global.entity.Freelancer;
import com.global.entity.Project;

import java.util.List;

@Repository
public class ProjectRepositoryCustomImpl implements ProjectRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private FreelancerRepository freelancerRepository;

    @Override
    public void addProject(Project project) {
        String email = ((BaseUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail();
        Freelancer freelancer = freelancerRepository.findByEmail(email);

        String sql = "INSERT INTO project (title, description, freelancer_id, search_vector, technologies_used) " +
                     "VALUES (:title, :description, :freelancer_id, to_tsvector('english', :search_vector), :technologies_used)"; 

        String searchVector = generateSearchVector(project.getTitle(), project.getDescription(), project.getTechnologiesUsed());

        String[] technologiesArray = project.getTechnologiesUsed().toArray(new String[0]);

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("title", project.getTitle());
        query.setParameter("description", project.getDescription());
        query.setParameter("freelancer_id", freelancer.getId());
        query.setParameter("search_vector", searchVector);
        query.setParameter("technologies_used", technologiesArray);

        query.executeUpdate();
    }

    private String generateSearchVector(String title, String description, List<String> technologiesUsed) {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append(" ").append(description).append(" ");
        for (String tech : technologiesUsed) {
            sb.append(tech).append(" ");
        }
        return sb.toString();
    }
}
