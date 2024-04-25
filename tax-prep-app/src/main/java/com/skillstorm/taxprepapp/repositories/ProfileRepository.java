package com.skillstorm.taxprepapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.taxprepapp.models.Profile;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    List<Profile> findByOauthId(String oauthId);
}
