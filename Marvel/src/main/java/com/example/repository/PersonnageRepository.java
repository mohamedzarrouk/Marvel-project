package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Personnage;

public interface PersonnageRepository extends CrudRepository<Personnage, Long>{

}
