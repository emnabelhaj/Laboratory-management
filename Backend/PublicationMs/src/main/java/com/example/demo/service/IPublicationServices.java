package com.example.demo.service;

import java.util.*;

import com.example.demo.entitie.Publication;


public interface IPublicationServices {

	public Publication addPublication(Publication m);
	public void deletePublication(Long id) ;
	public Publication updatePublication(Publication p) ;
	public Publication findPublication(Long id) ;
	public List<Publication> findAll();
	
	public List<Publication> findByType (String type);
	public Publication findByTitre (String titre);
	public List<Publication> findByLien (String lien);
	public List<Publication> findByDate (Date date);
	public List<Publication> findBySourcePdf (String type);



	
}
