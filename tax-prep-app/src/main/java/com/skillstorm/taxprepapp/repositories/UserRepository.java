package com.skillstorm.taxprepapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.skillstorm.taxprepapp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
