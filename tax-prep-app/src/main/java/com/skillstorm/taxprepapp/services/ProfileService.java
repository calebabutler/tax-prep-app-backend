package com.skillstorm.taxprepapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.taxprepapp.models.Profile;
import com.skillstorm.taxprepapp.repositories.ProfileRepository;

@Service
public class ProfileService extends BaseService<Profile> {

    @Override
    public boolean isValidForCreate(Profile profile) {
        return profile.getId() == null && profile.getFirstName() != null && profile.getLastName() != null
                && profile.getDateOfBirth() != null && profile.getAddress() != null && profile.getCity() != null
                && profile.getState() != null && profile.getAptNumber() != null && profile.getZipCode() != null
                && profile.getSsn() != null && profile.getUser() != null && profile.getFinanceInfo() == null;
    }

    @Override
    public boolean isValidForUpdate(Integer id, Profile profile) {
        if (id != null && profile.getId() == null) {
            profile.setId(id);
            return true;
        }
        return false;
    }

    @Autowired
    void setRepository(ProfileRepository repository) {
        this.repository = repository;
    }

}
