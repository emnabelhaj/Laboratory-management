package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity @DiscriminatorValue("ens")
public class EnseignantChercheur extends Membre implements Serializable{
	private String grade ,etablissement;
	private String role="ROLE_Enseignant";
	
	public EnseignantChercheur() {
		super();
	}

	

	public EnseignantChercheur( String cin, String nom, String prenom, String email, String cv, String password,
			Date date, String grade, String etablissement) {
		super( cin, nom, prenom, email, cv, password, date);
		this.grade = grade;
		this.etablissement = etablissement;
		this.role="ROLE_Enseignant";
	}



	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	

}
