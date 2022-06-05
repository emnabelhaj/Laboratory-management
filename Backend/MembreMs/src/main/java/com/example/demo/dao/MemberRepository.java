package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Membre;
@Repository
public interface MemberRepository extends JpaRepository<Membre, Long> {
	Membre findByCin(String cin);

	List<Membre> findByNomStartingWith(String caractere);

	Membre findByEmail(String email);
	
}