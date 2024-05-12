package com.abir.bijoux.repos; 
import org.springframework.data.jpa.repository.JpaRepository; 
import com.abir.bijoux.entities.User; 
public interface UserRepository extends JpaRepository<User, Long> { 
User findByUsername (String username); 
} 