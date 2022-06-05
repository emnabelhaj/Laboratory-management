package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Evenement;

import lombok.NonNull;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {
	
	List<Evenement> findByDate(Date date);
	Evenement findByTitre(String titre);
	Evenement findByLieu(String lieu);

}
