package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entitie.Publication;

@SpringBootApplication
@EnableDiscoveryClient
public class PublicationMsApplication  implements CommandLineRunner {
	@Autowired
	PublicationRepository publicationRepository ;
	@Autowired
	RepositoryRestConfiguration configuration ;
	
	public static void main(String[] args) {
		SpringApplication.run(PublicationMsApplication.class, args);
	
	}
	@Override
	public void run(String... args) throws Exception {
		configuration.exposeIdsFor(Publication.class);
		Publication p = new Publication("scientifique","titre","aa/bb",new Date(),"source") ;
		publicationRepository.save(p);
		System.out.println(p.getId());
		Publication p1 = new Publication("intelegence artificielle","deep learning","aa/bb",new Date(),"internet") ;
		publicationRepository.save(p1);
	}
	
}
