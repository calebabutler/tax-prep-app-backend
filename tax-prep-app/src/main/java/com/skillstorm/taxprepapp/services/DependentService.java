package com.skillstorm.taxprepapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.taxprepapp.models.Dependent;
import com.skillstorm.taxprepapp.repositories.DependentRepository;

@Service
public class DependentService extends BaseService<Dependent> {

    @Override
    public boolean isValidForCreate(Dependent dependent) {
        return dependent.getId() == null && dependent.getFirstName() != null && dependent.getLastName() != null
                && dependent.getSsn() != null && dependent.getRelationship() != null
                && dependent.getFinanceInfo() != null;
    }

    @Override
    public boolean isValidForUpdate(Integer id, Dependent dependent) {
        if (id != null && dependent.getId() == null) {
            dependent.setId(id);
            return true;
        }
        return false;
    }

    @Autowired
    void setRepository(DependentRepository repository) {
        this.repository = repository;
    }

}
