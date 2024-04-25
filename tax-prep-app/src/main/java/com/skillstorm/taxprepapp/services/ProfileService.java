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
        if (getProfile(oauthId).isEmpty() && profile.getId() == null && profile.getFirstName() != null &&
                profile.getMiddleInitial() != null && profile.getLastName() != null &&
                profile.getDateOfBirth() != null && profile.getAddress() != null && profile.getCity() != null &&
                profile.getState() != null && profile.getAptNumber() != null && profile.getZipCode() != null &&
                profile.getSsn() != null && profile.getOauthId() == null) {
            profile.setOauthId(oauthId);
            profileRepository.save(profile);
            return true;
        }
        return false;
    }

    public boolean updateProfile(String oauthId, Profile profile) {
        Optional<Profile> databaseProfile = getProfile(oauthId);
        if (databaseProfile.isPresent()) {
            profile.setId(databaseProfile.get().getId());
            profile.setOauthId(null);
            profileRepository.save(profile);
            return true;
        }
        return false;
    }

}
