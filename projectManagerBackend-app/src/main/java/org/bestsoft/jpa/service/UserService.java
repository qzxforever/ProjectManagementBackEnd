package org.bestsoft.jpa.service;

import org.bestsoft.jpa.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

	@Resource
	private UserRepository rep;
}
