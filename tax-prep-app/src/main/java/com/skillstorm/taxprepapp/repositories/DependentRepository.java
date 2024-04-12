package com.skillstorm.taxprepapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.taxprepapp.models.Dependent;

@Repository
public interface DependentRepository extends JpaRepository<Dependent, Integer> {
}
