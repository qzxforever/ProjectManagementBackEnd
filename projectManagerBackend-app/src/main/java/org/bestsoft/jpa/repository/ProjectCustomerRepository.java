package org.bestsoft.jpa.repository;

import org.bestsoft.jpa.entity.ProjectCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectCustomerRepository extends JpaRepository<ProjectCustomer, Long>, ProjectCustomerRepositoryCustom {
    List<ProjectCustomer> findAllByProjectId(Long projectId);
    List<ProjectCustomer> deleteProjectCustomersByProjectId(Long projectId);
    Page<ProjectCustomer> findAllByCustomerId(Long customerId, Pageable pageable);

}
