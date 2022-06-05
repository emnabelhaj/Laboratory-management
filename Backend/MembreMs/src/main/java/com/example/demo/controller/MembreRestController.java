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

import com.example.demo.service.IMembreServices;
import com.example.demo.entities.*;

@RestController 
@CrossOrigin
public class MembreRestController {
	@Autowired
	IMembreServices iMembreServices;

	@RequestMapping(value = "/membres", method = RequestMethod.GET)
	public List<Membre> findAll() {
		return iMembreServices.findAll();

	}

	@RequestMapping(value = "/membre/{id}", method = RequestMethod.GET)
	public Membre findMembres(@PathVariable Long id) {
		return iMembreServices.findMember(id);

	}

	@GetMapping(value = "/membre/search/cin")
	public Membre findOneMemberByCin(@RequestParam String cin)

	{
		return iMembreServices.findByCin(cin);
	}

	@GetMapping(value = "/membre/search/email")

	public Membre findOneMemberByEmail(@RequestParam String email)

	{
		return iMembreServices.findByEmail(email);
	}

	
	@PostMapping(value = "/membres/enseignant")

	public Membre addMembre(@RequestBody EnseignantChercheur m)

	{
		return iMembreServices.addMember(m);

	}

	@PostMapping(value = "/membres/etudiant")

	public Membre addMembre(@RequestBody Etudiant e)

	{
		return iMembreServices.addMember(e);
	}
	@PutMapping(value="/membres/etudiant/{id}")
	public Membre updatemembre(@PathVariable Long id, @RequestBody Etudiant p)
	{
		p.setId(id);
		return iMembreServices.updateMember(p);
	}

	@PutMapping(value="/membres/enseignant/{id}")
	public Membre updateMembreEnsg(@PathVariable Long id, @RequestBody EnseignantChercheur p)
	{
		p.setId(id);
	       return iMembreServices.updateMember(p);
	}
	@PutMapping(value="/membres/etudiant")
	public Etudiant affecter(@RequestParam Long idetd , @RequestParam Long idens )
	{
		
	       return iMembreServices.affecterEtudiantToEnseignant(idetd, idens);
	}
	@DeleteMapping(value="/membres/{id}")
	public void deleteMembre(@PathVariable Long id)
	{
		iMembreServices.deleteMember(id);
	}
	
	@GetMapping("/fullmemberPublications/{id}")
	
	public Membre findFullMember(@PathVariable(name="id") Long id)	{

	Membre mbr =iMembreServices.findMember(id);
	mbr.setPubs(iMembreServices.findPublicationparauteur(id));
	return mbr;
	}

	@GetMapping("/membersOutil/{id}")
	
	public Membre findFullMemberOutils(@PathVariable(name="id") Long id)	{

	Membre mbr =iMembreServices.findMember(id);
	mbr.setOutils(iMembreServices.findOutilparauteur(id));
	return mbr;
	}

	@GetMapping("/membersEvents/{id}")
	
	public Membre findFullMemberEvents(@PathVariable(name="id") Long id)	{

	Membre mbr =iMembreServices.findMember(id);
	mbr.setEvents(iMembreServices.findEvenementparauteur(id));
	return mbr;
	}

	@GetMapping("/fullmember/{id}")
	public Membre findAFullMember(@PathVariable(name="id") Long id)
	{
		Membre mbr=iMembreServices.findMember(id);
		mbr.setOutils(iMembreServices.findOutilparauteur(id));
		mbr.setEvents(iMembreServices.findEvenementparauteur(id));

		mbr.setPubs(iMembreServices.findPublicationparauteur(id));

		return mbr;
	}
}
