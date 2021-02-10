package com.example.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Personnage implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	Long idPersonnage;
	String nom;
	String description;
	String image;
	
	public Personnage() {
		
	}
	
	
	public Personnage(Long idPersonnage, String nom, String description, String image) {
		super();
		this.idPersonnage = idPersonnage;
		this.nom = nom;
		this.description = description;
		this.image = image;
	}


	public Long getIdPersonnage() {
		return idPersonnage;
	}
	public void setIdPersonnage(Long idPersonnage) {
		this.idPersonnage = idPersonnage;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	

}
