package com.example.demo.sevice;

import java.util.Date;
import java.util.List;

import com.example.demo.entites.Outil;


public interface IOutilServices {
	//crud sur les Outil
	public Outil addOutil(Outil o);
	public void deleteOutil(Long id) ;
	public Outil updateOutil(Outil p) ;
	public Outil findOutil(Long id) ;
	public List<Outil> findAll(); 
	
	public List<Outil> findByDate(Date d);
	public Outil findBySource (String source);
}
