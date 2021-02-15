package com.example.entities;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personnages")
public class Personnage {
	

	Long idPersonnage;
	String nom;
	String description;
	String image;
	
	public Personnage() {
		
	}
	
	
	public Personnage(Long idPersonnage, String nom, String description, String image) {
		this.idPersonnage = idPersonnage;
		this.nom = nom;
		this.description = description;
		this.image = image;
	}


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
