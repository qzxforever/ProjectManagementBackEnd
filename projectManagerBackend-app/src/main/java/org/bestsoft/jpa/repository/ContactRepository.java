package org.bestsoft.jpa.repository;

import org.bestsoft.jpa.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long>, ContactRepositoryCustom {
    Page<Contact> findAllByNameContains(String name, Pageable pageable);

    Page<Contact> findAllByCustomerId(Long id, Pageable pageable);
}
