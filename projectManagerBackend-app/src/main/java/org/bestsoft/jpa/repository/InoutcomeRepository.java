package org.bestsoft.jpa.repository;

import org.bestsoft.jpa.entity.Inoutcome;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InoutcomeRepository extends JpaRepository<Inoutcome, Long>, InoutcomeRepositoryCustom {
    Page<Inoutcome> findAllByProjectId(Long projectId, Pageable pageable);
}
