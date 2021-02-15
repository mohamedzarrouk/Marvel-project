package com.example.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Personnage;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.PersonnageRepository;

@Service
public class PersonnageService {
	
	@Autowired
	PersonnageRepository personnageRepository;
	
	public List<Personnage> getPersonnages(){
		return (List<Personnage>) personnageRepository.findAll();
		
	}
	
	public Optional<Personnage> getPersonnageById(Long id) {
		return personnageRepository.findById(id);
	}
	
	public Personnage creatSuperHero(Personnage personnage) {
		return personnageRepository.save(personnage);
	}
	
	/*
	public void deleteSuperHero(Long id) {
		
		personnageRepository.deleteById(id);
	}
	*/
	
    public Map<String, Boolean> deletePersonnage(Long personnageId)
            throws ResourceNotFoundException {
           Personnage personnage = personnageRepository.findById(personnageId)
          .orElseThrow(() -> new ResourceNotFoundException("personnage n'existe pas :: " + personnageId));

           personnageRepository.delete(personnage);
           Map<String, Boolean> response = new HashMap<>();
           response.put("deleted", Boolean.TRUE);
           return response;
       }

}
