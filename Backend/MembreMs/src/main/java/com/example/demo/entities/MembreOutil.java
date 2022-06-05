package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


@Entity

public class MembreOutil {

	@EmbeddedId
	private MembreOutilIds id ;
	@ManyToOne @MapsId("auteur_id")
	private Membre auteur ;
	public MembreOutil() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MembreOutil(MembreOutilIds id, Membre auteur) {
		super();
		this.id = id;
		this.auteur = auteur;
	}
	public MembreOutilIds getId() {
		return id;
	}
	public void setId(MembreOutilIds id) {
		this.id = id;
	}
	public Membre getAuteur() {
		return auteur;
	}
	public void setAuteur(Membre auteur) {
		this.auteur = auteur;
	}
	
}
