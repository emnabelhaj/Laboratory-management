package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.MembrePubIds;
import com.example.demo.entities.MembrePublication;

public interface MembrePubRepository extends JpaRepository<MembrePublication, MembrePubIds> {

	@Query("select m from MembrePublication m where auteur_id=:x")
	List< MembrePublication> findpubId(@Param ("x") Long autId) ;
}
