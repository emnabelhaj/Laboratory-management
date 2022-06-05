package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.hibernate.annotations.ManyToAny;

@Entity
public class MembrePublication {
	@EmbeddedId
	private MembrePubIds id ;
	@ManyToOne @MapsId("auteur_id")
	private Membre auteur ;
	public MembrePublication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MembrePublication(MembrePubIds id, Membre auteur) {
		super();
		this.id = id;
		this.auteur = auteur;
	}
	public MembrePubIds getId() {
		return id;
	}
	public void setId(MembrePubIds id) {
		this.id = id;
	}
	public Membre getAuteur() {
		return auteur;
	}
	public void setAuteur(Membre auteur) {
		this.auteur = auteur;
	}
	
}


