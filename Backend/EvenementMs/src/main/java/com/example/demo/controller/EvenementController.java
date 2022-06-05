package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Evenement;
import com.example.demo.service.IEvenementService;



@RestController 
@CrossOrigin
public class EvenementController {
	@Autowired
	IEvenementService evenementService ;
	@RequestMapping(value = "/evenements", method = RequestMethod.GET)
	public List<Evenement> findAll() {
		return evenementService.findAll();

	}

	@RequestMapping(value = "/evenement/{id}", method = RequestMethod.GET)
	public Evenement findPublications(@PathVariable Long id) {
		return evenementService.findEvenement(id);

	}

	@GetMapping(value = "/Evenement/search/title")
	public Evenement findOneEvenementByTitle(@RequestParam String title)

	{
		return evenementService.findByTitre(title);
	}

	@GetMapping(value = "/evenement/search/lieu")

	public Evenement findByLieu(@RequestParam String lieu)

	{
		return evenementService.findByLieu(lieu);
	}
	@GetMapping(value = "/evenement/search/date")

	public List <Evenement> findByLieu(@RequestParam Date date)

	{
		return evenementService.findByDate(date);
	}

	@PostMapping(value = "/evenement")

	public Evenement addEvenement(@RequestBody Evenement p)

	{
		return evenementService.addEvenement(p);

	}


	@PutMapping(value="/evenement/{id}")
	public Evenement updateEvenement(@PathVariable Long id, @RequestBody Evenement e)
	{
		e.setId(id);
	       return evenementService.updateEvenement(e);
	}
	
	@DeleteMapping(value="/evenement/{id}")
	public void deleteEvenement(@PathVariable Long id)
	{
		evenementService.deleteEvenement(id);
	}

}
