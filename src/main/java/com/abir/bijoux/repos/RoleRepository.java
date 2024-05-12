package com.abir.bijoux.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abir.bijoux.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}