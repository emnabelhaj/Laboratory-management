package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.EvenementBean;
import com.example.demo.bean.OutilBean;
import com.example.demo.bean.PublicationBean;
import com.example.demo.entities.*;

public interface IMembreServices {
	// Crud sur les membres
	public Membre addMember(Membre m);

	public void deleteMember(Long id);

	public Membre updateMember(Membre p);

	public Membre findMember(Long id);

	public List<Membre> findAll();

	// Filtrage par propriété
	public Membre findByCin(String cin);

	public Membre findByEmail(String email);

	public List<Membre> findByNom(String nom);

	// recherche spécifique des étudiants
	public List<Etudiant> findByDiplome(String diplome);

	// recherche spécifique des enseignants
	public List<EnseignantChercheur> findByGrade(String grade);

	public List<EnseignantChercheur> findByEtablissement(String etablissement);

	public Etudiant affecterEtudiantToEnseignant(Long idetd, Long idens);

	public List<Etudiant> findByEncadrant(EnseignantChercheur idens);

	// Affecter une publication à un auteur:
	public void affecterauteurTopublication(Long idauteur, Long idpub);
	// Récupérer les publications d’un auteur
	public List<PublicationBean> findPublicationparauteur(Long idauteur);
	
	// Affecter une outil à un auteur:
	public void affecterauteurTooutil(Long idauteur, Long idoutil);
	// Récupérer les outil d’un auteur
	public List<OutilBean> findOutilparauteur(Long idauteur);

	// Affecter une evenement à un auteur:
	public void affecterauteurToEvenement(Long idauteur, Long idevent);
	// Récupérer les evenement d’un auteur
	public List<EvenementBean> findEvenementparauteur(Long idauteur);
	
	
	
}
