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

import com.example.demo.entites.Outil;
import com.example.demo.sevice.IOutilServices;

@RestController
@CrossOrigin
public class OutilController {
	@Autowired
	IOutilServices iOutilServices ;
	
	@RequestMapping(value = "/outils", method = RequestMethod.GET)
	public List<Outil> findAll() {
		return iOutilServices.findAll();

	}

	@GetMapping(value = "/outil/search/source")
	public Outil findOutilBySource(@RequestParam String source)

	{
		return iOutilServices.findBySource(source);
	}

	@GetMapping(value = "/outil/search/date")

	public List<Outil> findOutilByDate(@RequestParam Date date)

	{
		return iOutilServices.findByDate(date);
	}

	@PostMapping(value = "/outil")

	public Outil addOutil(@RequestBody Outil o)

	{
		return iOutilServices.addOutil(o);

	}

	@PutMapping(value="/outil/{id}")
	public Outil updateOutil(@PathVariable Long id, @RequestBody Outil o)
	{
		o.setId(id);
		return iOutilServices.updateOutil(o);
	}

	@DeleteMapping(value="/outil/{id}")
	public void deleteOutil(@PathVariable Long id)
	{
		iOutilServices.deleteOutil(id);
	}
	

}
