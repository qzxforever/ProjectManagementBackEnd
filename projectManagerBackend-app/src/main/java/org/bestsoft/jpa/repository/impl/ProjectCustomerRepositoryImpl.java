package org.bestsoft.jpa.repository.impl;

import org.bestsoft.jpa.repository.ProjectCustomerRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProjectCustomerRepositoryImpl implements ProjectCustomerRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
}
