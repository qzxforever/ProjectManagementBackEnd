package org.bestsoft.jpa.repository.impl;

import org.bestsoft.jpa.repository.ProjectJobRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProjectJobRepositoryImpl implements ProjectJobRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
}
