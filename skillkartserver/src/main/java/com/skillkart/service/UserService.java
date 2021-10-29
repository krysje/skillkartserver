package com.skillkart.service;

import java.util.Set;


import com.skillkart.entity.Role;
import com.skillkart.entity.User;


public interface UserService {
	
	public User createUser(User user, Set<Role> userRoles) throws Exception;
	
}
