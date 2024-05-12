package com.abir.bijoux.service;

import com.abir.bijoux.entities.Role;
import com.abir.bijoux.entities.User;

public interface UserService {
	void deleteAllusers();

	void deleteAllRoles();

	User saveUser(User user);

	User findUserByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);

}