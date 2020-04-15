package org.bestsoft.jpa.repository;

import org.bestsoft.jpa.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom{
    Page<Customer> findAllByNameContains(String name, Pageable pageable);
}
