package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;

@Service
public class EvenementServiceImp implements IEvenementService{
	@Autowired
	EvenementRepository evenementRepo ;

	@Override
	public Evenement addEvenement(Evenement e) {
		return evenementRepo.save(e);
	}

	@Override
	public void deleteEvenement(Long id) {
		if (evenementRepo.findById(id).isPresent())
			evenementRepo.deleteById(id);
	}

	@Override
	public Evenement updateEvenement(Evenement e) {
		return evenementRepo.saveAndFlush(e);
	}

	@Override
	public Evenement findEvenement(Long id) {
		return evenementRepo.findById(id).get();
	}

	@Override
	public List<Evenement> findAll() {
		return evenementRepo.findAll();
	}

	@Override
	public List<Evenement> findByDate(Date d) {
		return  evenementRepo.findByDate(d);
	}

	@Override
	public Evenement findByTitre(String titre) {
		return evenementRepo.findByTitre(titre);
	}

	@Override
	public Evenement findByLieu(String lieu) {
		return evenementRepo.findByLieu(lieu);
	}
	

}
