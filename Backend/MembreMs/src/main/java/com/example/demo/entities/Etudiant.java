package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity @DiscriminatorValue("etd")
public class Etudiant extends Membre implements Serializable{
	private String diplome;
	private Date date;	
	private String role="ROLE_Etudiant";
	@ManyToOne
	private EnseignantChercheur encadrant;
	
	public Etudiant() {
		super();
	}
	
	public Etudiant(String cin, String nom, String prenom, String email, String cv, String password, Date date,
			String diplome, Date date2, EnseignantChercheur encadrant) {
		super( cin, nom, prenom, email, cv, password, date);
		this.diplome = diplome;
		date = date2;
		this.encadrant = encadrant;
		this.role="Etudiant";

	}






	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public EnseignantChercheur getEncadrant() {
		return encadrant;
	}
	public void setEncadrant(EnseignantChercheur encadrant) {
		this.encadrant = encadrant;
	}

}
