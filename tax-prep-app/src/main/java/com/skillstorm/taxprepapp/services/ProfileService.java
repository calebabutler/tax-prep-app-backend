package com.skillstorm.taxprepapp.services;

import com.skillstorm.taxprepapp.models.Profile;
import com.skillstorm.taxprepapp.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public Optional<Profile> getProfile(String oauthId) {
        List<Profile> profiles = profileRepository.findByOauthId(oauthId);
        if (profiles.isEmpty()) {
            return Optional.empty();
        }
        Profile profile = profiles.get(0);
        profile.setId(null);
        profile.setOauthId(null);
        return Optional.of(profile);
    }

    /* Returns whether it was successful or not */
    public boolean createProfile(String oauthId, Profile profile) {
        if (getProfile(oauthId).isEmpty() && profile.getId() == null && profile.getFirstName() != null
                && profile.getLastName() != null && profile.getDateOfBirth() != null && profile.getAddress() != null
                && profile.getCity() != null &&
                profile.getState() != null && profile.getZipCode() != null &&
                profile.getSsn() != null) {
            profile.setOauthId(oauthId);
            profileRepository.save(profile);
            return true;
        }
        return false;
    }

    public boolean updateProfile(String oauthId, Profile profile) {
        List<Profile> profiles = profileRepository.findByOauthId(oauthId);
        if (profiles.isEmpty()) {
            return false;
        }
        Profile databaseProfile = profiles.get(0);
        databaseProfile.setFirstName(profile.getFirstName());
        databaseProfile.setMiddleInitial(profile.getMiddleInitial());
        databaseProfile.setLastName(profile.getLastName());
        databaseProfile.setDateOfBirth(profile.getDateOfBirth());
        databaseProfile.setAddress(profile.getAddress());
        databaseProfile.setCity(profile.getCity());
        databaseProfile.setState(profile.getState());
        databaseProfile.setAptNumber(profile.getAptNumber());
        databaseProfile.setZipCode(profile.getZipCode());
        databaseProfile.setSsn(profile.getSsn());
        profileRepository.save(databaseProfile);
        return true;
    }

}
