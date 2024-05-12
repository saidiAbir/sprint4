package com.abir.bijoux.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.abir.bijoux.entities.Marque; 


public interface MarqueRepository extends JpaRepository<Marque, Long>   {

}
