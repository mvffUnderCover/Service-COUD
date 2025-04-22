package com.techservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techservice.model.DemandeDepannage;

public interface DemandeDepannageRepository extends JpaRepository<DemandeDepannage, Integer> {}
