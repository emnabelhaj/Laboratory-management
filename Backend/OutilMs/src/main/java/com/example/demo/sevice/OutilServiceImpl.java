package com.example.demo.sevice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entites.Outil;

@Service
public class OutilServiceImpl implements IOutilServices {
	@Autowired
	OutilRepository outilRepository;

	@Override
	public Outil addOutil(Outil o) {
		return outilRepository.save(o);
	}

	@Override
	public void deleteOutil(Long id) {
		if (outilRepository.findById(id).isPresent())
			outilRepository.deleteById(id);
	}

	@Override
	public Outil updateOutil(Outil p) {
		return outilRepository.saveAndFlush(p);
	}

	@Override
	public Outil findOutil(Long id) {
		return outilRepository.findById(id).get();
	}

	@Override
	public List<Outil> findAll() {
		return outilRepository.findAll();
	}

	@Override
	public List<Outil> findByDate(Date d) {
		return outilRepository.findByDate(d);
	}

	@Override
	public Outil findBySource(String source) {
		return (Outil) outilRepository.findBySource(source);
	}

}
