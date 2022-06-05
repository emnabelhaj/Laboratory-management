package com.example.demo.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entitie.Publication;
@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
	List<Publication> findByDate(Date date);
	List<Publication> findBySourcePdf(String sourcePdf);
	List<Publication> findByType(String type);
	List<Publication> findByTitre(String titre);
	List<Publication> findByLien(String lien);

}
