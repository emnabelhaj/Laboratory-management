package com.example.demo;

import com.example.demo.entities.*;
import com.example.demo.proxy.EvenementProxyService;
import com.example.demo.proxy.OutilProxyService;
import com.example.demo.proxy.PublicationProxyService;
import com.example.demo.service.IMembreServices;
import com.example.demo.bean.EvenementBean;
import com.example.demo.bean.OutilBean;
import com.example.demo.bean.PublicationBean;
import com.example.demo.dao.*;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MembreMsApplication implements CommandLineRunner {
	@Autowired
	MemberRepository membreRepository ;
	@Autowired
	IMembreServices iMembreServices ;
	@Autowired
	PublicationProxyService pubProxyService ;
	@Autowired
	OutilProxyService outilProxyService ;
	@Autowired
	EvenementProxyService evenementProxyService ;

	public static void main(String[] args) {
		SpringApplication.run(MembreMsApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		Etudiant etd1 = new Etudiant( ) ;
		membreRepository.save(etd1);
		EnseignantChercheur ens = new EnseignantChercheur("222222","Madame","cc","madame.mm@enis.tn","","123456789",new Date(),"Maitre","ENIS");
		membreRepository.save(ens);
		Etudiant etd2 = new Etudiant("1111111","Maroua","CHOURA","@enis","","1245689", new Date(),"eleve ing",new Date() ,ens) ;
		membreRepository.save(etd2);
		// Update a Member
		Membre m= iMembreServices.findMember(1L);

		m.setCv("cv1.pdf");
		iMembreServices.updateMember(m);
		
		PublicationBean pb = pubProxyService.findPublicationBy(1L);
		System.out.println(pb.getId() +" "+ pb.getTitre());
		
		iMembreServices.affecterauteurTopublication(1L, 1L);
		iMembreServices.affecterauteurTopublication(1L, 2L);
		iMembreServices.affecterauteurTopublication(2L, 2L);
		
		
		//
		List<PublicationBean> pubs = iMembreServices.findPublicationparauteur(1L);
		pubs.forEach(pub -> {
			System.out.println(pub.getId()+" " + pub.getTitre());
		});
		////// outil
		OutilBean outil = outilProxyService.findOutilBy(1L);
		System.out.println(outil.getId()+ " " + outil.getSource());
		
		OutilBean outil2 = outilProxyService.findOutilBy(2L);
		System.out.println(outil2.getId()+ " " + outil2.getSource());
		
		iMembreServices.affecterauteurTooutil(1L, 1L);
		iMembreServices.affecterauteurTooutil(2L,2L);
		/////// Events
		EvenementBean event = evenementProxyService.findEvenementBy(1L);
		System.out.println(event.getTitre()+ " "+event.getLieu());
		iMembreServices.affecterauteurToEvenement(1L, 1L);
	}

}
