package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.EvenementBean;
import com.example.demo.bean.OutilBean;
import com.example.demo.bean.PublicationBean;
import com.example.demo.dao.EnseignantChercheurRepository;
import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.MemberRepository;
import com.example.demo.dao.MembreEvenementRepository;
import com.example.demo.dao.MembreOutilRepository;
import com.example.demo.dao.MembrePubRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.entities.MembreEvenement;
import com.example.demo.entities.MembreEvenementIds;
import com.example.demo.entities.MembreOutil;
import com.example.demo.entities.MembreOutilIds;
import com.example.demo.entities.MembrePubIds;
import com.example.demo.entities.MembrePublication;
import com.example.demo.proxy.EvenementProxyService;
import com.example.demo.proxy.OutilProxyService;
import com.example.demo.proxy.PublicationProxyService;
@Service @Transactional
public class MembreServiceImpl implements IMembreServices{
	@Autowired
	MemberRepository memberRepository ;
	@Autowired
	EtudiantRepository etudiantRepository ;
	@Autowired
	EnseignantChercheurRepository enseignantChercheurRepository ;
	@Autowired
	MembrePubRepository membrePubRepository ;
	@Autowired
	PublicationProxyService puProxyService ;
	@Autowired
	MembreOutilRepository membreOutilRepository ;
	@Autowired
	OutilProxyService outilProxyService ;
	@Autowired
	MembreEvenementRepository membreEvenementRepository ;
	@Autowired
	EvenementProxyService evenementProxyService ; 
	
	
	@Override
	public Membre addMember(Membre m) {
		return memberRepository.save(m);
	}

	@Override
	public void deleteMember(Long id) {
		if (memberRepository.findById(id).isPresent())
			memberRepository.deleteById(id);
	}

	@Override
	public Membre updateMember(Membre p) {
		return memberRepository.saveAndFlush(p);
	}

	@Override
	public Membre findMember(Long id) {
		return memberRepository.findById(id).get();
	}

	@Override
	public List<Membre> findAll() {
		return memberRepository.findAll();
	}

	@Override
	public Membre findByCin(String cin) {
		return memberRepository.findByCin(cin);
	}

	@Override
	public Membre findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	@Override
	public List<Membre> findByNom(String nom) {
		return memberRepository.findByNomStartingWith(nom);
	}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {
		return etudiantRepository.findByDiplome(diplome);
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {
		return enseignantChercheurRepository.findByGrade(grade);
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		return enseignantChercheurRepository.findByEtablissement(etablissement) ;
	}
	
	@Override
	public Etudiant affecterEtudiantToEnseignant(Long idetd , Long idens) {
		Etudiant e = etudiantRepository.findById(idetd).get();
		EnseignantChercheur ens = enseignantChercheurRepository.findById(idens).get() ;
		e.setEncadrant(ens);
		return etudiantRepository.save(e);
		
		
	}

	@Override
	public List<Etudiant> findByEncadrant(EnseignantChercheur idens) {
		return etudiantRepository.findByEncadrant(idens);
	}

	@Override
	public void affecterauteurTopublication(Long idauteur, Long idpub) {
		Membre auteur =memberRepository.findById(idauteur).get() ;
		MembrePublication mbs = new MembrePublication();
		mbs.setAuteur(auteur);
		mbs.setId(new MembrePubIds(idpub, idauteur));
		membrePubRepository.save(mbs);
		
		}

	@Override
	public List<PublicationBean> findPublicationparauteur(Long idauteur) {
		List<PublicationBean> pubBean = new ArrayList<PublicationBean>() ;
		List <MembrePublication> pubs = membrePubRepository.findpubId(idauteur) ;
		pubs.forEach(s-> {
			//System.out.println(s);
			pubBean.add(puProxyService.findPublicationBy(s.getId().getPublication_id()));
		});
			
		return pubBean;
	}
	
	@Override
	public void affecterauteurTooutil(Long idauteur, Long idoutil) {

		Membre mbre = memberRepository.findById(idauteur).get() ;
		MembreOutil mbOutil = new MembreOutil() ;
		mbOutil.setAuteur(mbre);
		mbOutil.setId(new MembreOutilIds(idoutil, idauteur));
		membreOutilRepository.save(mbOutil);
	}
	@Override
	public List<OutilBean> findOutilparauteur(Long idauteur) {
		List <OutilBean> outils = new ArrayList <OutilBean>() ;
		List <MembreOutil> mbreOutils = membreOutilRepository.findoutilId(idauteur) ;
		mbreOutils.forEach(s -> {
			//System.out.println(s);
			outils.add(outilProxyService.findOutilBy(s.getId().getOutil_id()));
		});
		return outils;
	}

	@Override
	public List<EvenementBean> findEvenementparauteur(Long idauteur) {
		List <EvenementBean> events = new ArrayList <EvenementBean>() ;
		List <MembreOutil> mbreOutils = membreOutilRepository.findoutilId(idauteur) ;
		mbreOutils.forEach(s -> {
			//System.out.println(s);
			events.add(evenementProxyService.findEvenementBy(s.getId().getOutil_id()));
		});
		return events;
	}

	@Override
	public void affecterauteurToEvenement(Long idauteur, Long idevent) {

		Membre mbre = memberRepository.findById(idauteur).get() ;
		MembreEvenement mbEvent = new MembreEvenement() ;
		mbEvent.setAuteur(mbre);
		mbEvent.setId(new MembreEvenementIds(idevent, idauteur));
		membreEvenementRepository.save(mbEvent);
	}


	
}
