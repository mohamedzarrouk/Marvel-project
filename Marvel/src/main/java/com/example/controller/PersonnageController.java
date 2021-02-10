package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Personnage;
import com.example.exception.ResourceNotFoundException;
import com.example.services.PersonnageService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="gateway.marvel.com/v1/public")
@RestController
public class PersonnageController {
	
	@Autowired
	PersonnageService personnageService;
	

	
	//Affichage de tous les personnages dans la liste
    @GetMapping("/characters")
    public List<Personnage> getAllPersonnage() {
        return personnageService.getPersonnages();
    }
    
    //Affichage d'un personnage par son Id
    @GetMapping("/characters/{characterId}")
    public ResponseEntity<Personnage> getPersonnageById(@PathVariable(value = "characterId") Long personnageId)
        throws ResourceNotFoundException {
        Personnage personnage = personnageService.getPersonnageById(personnageId)
          .orElseThrow(() -> new ResourceNotFoundException("personnage n'existe pas :: " + personnageId));
        return ResponseEntity.ok().body(personnage);
    }
    
    //Ajout d'un nouveau personnage
    @PostMapping("/characters")
    public Personnage creatPersonnage(@RequestBody Personnage personnage) {
        return personnageService.creatSuperHero(personnage);
    }
    
    //Suppression d'un personnage
    @DeleteMapping("/characters/{characterId}")
    public Map<String, Boolean> deletePersonnage(@PathVariable(value = "charactersId") Long personnageId)
    		throws ResourceNotFoundException{

        personnageService.deletePersonnage(personnageId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    
}
