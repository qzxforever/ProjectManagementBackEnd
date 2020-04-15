package org.bestsoft.jpa.repository.impl;

import org.bestsoft.jpa.repository.ProjectRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
}
