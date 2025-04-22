package com.techservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techservice.model.Section;

public interface SectionRepository extends JpaRepository<Section, Integer> {}
