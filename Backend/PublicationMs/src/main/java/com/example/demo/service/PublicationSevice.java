package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entitie.Publication;

@Service
public class PublicationSevice implements IPublicationServices {
	@Autowired
	PublicationRepository publicationRepository;

	@Override
	public Publication addPublication(Publication m) {
		return publicationRepository.save(m);
	}

	@Override
	public void deletePublication(Long id) {
		if (publicationRepository.findById(id).isPresent())
			publicationRepository.deleteById(id);
	}

	@Override
	public Publication updatePublication(Publication p) {
		return publicationRepository.saveAndFlush(p);
	}

	@Override
	public Publication findPublication(Long id) {
		return publicationRepository.findById(id).get();
	}

	@Override
	public List<Publication> findAll() {
		return publicationRepository.findAll();
	}

	@Override
	public List<Publication> findByType(String type) {
		return publicationRepository.findByType(type);
	}

	@Override
	public Publication findByTitre(String titre) {
		return (Publication) publicationRepository.findByTitre(titre);
	}

	@Override
	public List<Publication> findByLien(String lien) {
		return publicationRepository.findByLien(lien);
	}

	@Override
	public List<Publication> findByDate(Date date) {
		return publicationRepository.findByDate(date);
	}

	@Override
	public List<Publication> findBySourcePdf(String sourcePdf) {
		return publicationRepository.findBySourcePdf(sourcePdf);
	}

}
