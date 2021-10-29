package com.skillkart.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillkart.entity.Role;
import com.skillkart.entity.User;
import com.skillkart.repository.RoleRepo;
import com.skillkart.repository.UserRepo;
import com.skillkart.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	
	@Override
	public User createUser(User user, Set<Role> userRoles) throws Exception {
		
		User local = this.userRepo.findByUsername(user.getUsername());
		
		if(local != null) {
			throw new Exception("User already present");
		}
		
		else {
			
			for(Role r : userRoles) {
				roleRepo.save(r);
				r.getUsers().add(user);
			}
					
			local = this.userRepo.save(user);
			user.getRoles().addAll(userRoles);
		}
		
		return local;
	}
	
}
