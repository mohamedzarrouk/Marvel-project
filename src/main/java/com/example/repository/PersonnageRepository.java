package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Personnage;

@Repository
public interface PersonnageRepository extends JpaRepository<Personnage, Long>{

}
