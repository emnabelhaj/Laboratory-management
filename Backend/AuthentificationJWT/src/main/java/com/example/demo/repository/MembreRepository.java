package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Membre;

@Repository
public interface MembreRepository extends JpaRepository<Membre,Long> {
    Membre findByEmail(String email);
}