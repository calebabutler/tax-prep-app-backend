package com.skillstorm.taxprepapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.skillstorm.taxprepapp.models.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {
    public Optional<AppUser> findByEmail(String email);
}
