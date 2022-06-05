package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.MembreEvenement;
import com.example.demo.entities.MembreEvenementIds;

public interface MembreEvenementRepository extends JpaRepository<MembreEvenement, MembreEvenementIds> {

	@Query("select m from MembreEvenement m where auteur_id=:x")
	List< MembreEvenement> findoutilId(@Param ("x") Long autId) ;


}
