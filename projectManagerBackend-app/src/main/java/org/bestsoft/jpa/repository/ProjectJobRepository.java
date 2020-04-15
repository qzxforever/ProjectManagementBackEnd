package org.bestsoft.jpa.repository;

import org.bestsoft.jpa.entity.ProjectJob;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectJobRepository extends JpaRepository<ProjectJob, Long>, ProjectJobRepositoryCustom{
    Page<ProjectJob> findAllByProjectId(Long projectId, Pageable pageable);
}
