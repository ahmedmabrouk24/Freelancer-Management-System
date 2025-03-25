package com.global.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.global.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>, ProjectRepositoryCustom {
    
	@Query(value = "SELECT * FROM project p WHERE to_tsvector(p.title || ' ' || p.description || ' ' || array_to_string(p.technologies_used, ' ')) @@ to_tsquery(:query) AND p.freelancer_id = :freelancerId", nativeQuery = true)
    List<Project> searchProjectsByQuery(@Param("query") String query, @Param("freelancerId") Long freelancerId);
	
}