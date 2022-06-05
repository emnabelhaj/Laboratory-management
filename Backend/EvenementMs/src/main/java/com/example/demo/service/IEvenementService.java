package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Evenement;






public interface IEvenementService {
//crud sur les Outil
	public Evenement addEvenement(Evenement e);
	public void deleteEvenement(Long id) ;
	public Evenement updateEvenement(Evenement p) ;
	public Evenement findEvenement(Long id) ;
	public List<Evenement> findAll(); 
	
	public List<Evenement> findByDate(Date d);
	public Evenement findByTitre (String titre);
	public Evenement findByLieu (String lieu);
	

}
