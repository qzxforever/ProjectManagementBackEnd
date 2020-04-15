package org.bestsoft.jpa.repository.impl;

import org.bestsoft.jpa.repository.ContactRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ContactRepositoryImpl implements ContactRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
}
