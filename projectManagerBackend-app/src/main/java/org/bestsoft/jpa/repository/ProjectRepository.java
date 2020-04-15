package org.bestsoft.jpa.repository;

import org.bestsoft.jpa.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long>, ProjectRepositoryCustom{
    List<Project> findAll();
    Page<Project> findAllByNameContains(String name, Pageable pageable);
}
