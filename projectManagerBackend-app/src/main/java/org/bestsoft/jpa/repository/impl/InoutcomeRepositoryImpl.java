package org.bestsoft.jpa.repository.impl;

import org.bestsoft.jpa.repository.InoutcomeRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class InoutcomeRepositoryImpl implements InoutcomeRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
}
