package com.example.demo;

import java.util.* ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;


@SpringBootApplication
@EnableDiscoveryClient
public class EvenementMsApplication implements CommandLineRunner {
	@Autowired
	EvenementRepository evenementRepository ;
	@Autowired
	RepositoryRestConfiguration configuration;
	public static void main(String[] args) {
		SpringApplication.run(EvenementMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		configuration.exposeIdsFor(Evenement.class);
		Evenement event1 = new Evenement("Pitch", new Date(), "ENIS");
		evenementRepository.save(event1);
		Evenement event2 = new Evenement("ENIF", new Date(), "ENIS");
		evenementRepository.save(event2);
	}

}
