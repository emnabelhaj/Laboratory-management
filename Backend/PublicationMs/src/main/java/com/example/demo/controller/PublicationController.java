package com.example.demo.controller;

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

import com.example.demo.entitie.Publication;
import com.example.demo.service.IPublicationServices;

@CrossOrigin
@RestController
public class PublicationController {
	@Autowired
	IPublicationServices iPublicationServices ;
	@RequestMapping(value = "/publications", method = RequestMethod.GET)
	public List<Publication> findAll() {
		return iPublicationServices.findAll();

	}

	@RequestMapping(value = "/publication/{id}", method = RequestMethod.GET)
	public Publication findPublications(@PathVariable Long id) {
		return iPublicationServices.findPublication(id);

	}

	@GetMapping(value = "/publication/search/title")
	public Publication findOnePublicationByTitle(@RequestParam String title)

	{
		return iPublicationServices.findByTitre(title);
	}

	@GetMapping(value = "/membre/search/type")

	public List<Publication> findByType(@RequestParam String type)

	{
		return iPublicationServices.findByType(type);
	}

	@PostMapping(value = "/publication")

	public Publication addPublication(@RequestBody Publication p)

	{
		return iPublicationServices.addPublication(p);

	}


	@PutMapping(value="/publication/{id}")
	public Publication updatePublication(@PathVariable Long id, @RequestBody Publication p)
	{
		p.setId(id);
	       return iPublicationServices.updatePublication(p);
	}
	
	@DeleteMapping(value="/publication/{id}")
	public void deletePublication(@PathVariable Long id)
	{
		iPublicationServices.deletePublication(id);
	}

}
