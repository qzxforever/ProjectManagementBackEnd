package org.bestsoft.jpa.repository.impl;

import org.bestsoft.jpa.repository.UserRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
}
