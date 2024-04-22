package com.skillstorm.taxprepapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.taxprepapp.models.User;
import com.skillstorm.taxprepapp.repositories.UserRepository;

@Service
public class UserService extends BaseService<User> {

    @Override
    public boolean isValidForCreate(User user) {
        return user.getId() == null && user.getEmail() != null && user.getPassword() != null
                && user.getProfiles() == null;
    }

    @Override
    public boolean isValidForUpdate(Integer id, User user) {
        if (id != null && user.getId() == null) {
            user.setId(id);
            return true;
        }
        return false;
    }

    @Autowired
    void setRepository(UserRepository repository) {
        this.repository = repository;
    }

}
