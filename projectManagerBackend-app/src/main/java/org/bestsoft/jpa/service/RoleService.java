package org.bestsoft.jpa.service;

import org.bestsoft.jpa.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService {

	@Resource
	private RoleRepository rep;
}
