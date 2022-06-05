package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.MembreOutil;
import com.example.demo.entities.MembrePubIds;

public interface MembreOutilRepository extends JpaRepository<MembreOutil, MembrePubIds> {

	@Query("select m from MembreOutil m where auteur_id=:x")
	List< MembreOutil> findoutilId(@Param ("x") Long autId) ;

}
