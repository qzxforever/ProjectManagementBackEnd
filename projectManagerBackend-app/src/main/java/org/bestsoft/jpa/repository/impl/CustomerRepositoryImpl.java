package org.bestsoft.jpa.repository.impl;

import org.bestsoft.jpa.repository.CustomerRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
}
