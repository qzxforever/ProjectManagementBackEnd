package org.bestsoft.jpa.repository.impl;

import org.bestsoft.jpa.repository.RoleRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleRepositoryImpl implements RoleRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
}
