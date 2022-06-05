package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entites.Outil;


@SpringBootApplication
@EnableDiscoveryClient
public class OutilMsApplication implements CommandLineRunner {
	 @Autowired 
	 OutilRepository outilRepository ;
	 @Autowired
	 RepositoryRestConfiguration configuration ;
	public static void main(String[] args) {
		SpringApplication.run(OutilMsApplication.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
		configuration.exposeIdsFor(Outil.class);
		Outil o1 = new Outil(new Date(), " source ");
		outilRepository.save(o1);
		
		Outil o2 = new Outil(new Date(), " source 2 ");
		outilRepository.save(o2);
	}

}
