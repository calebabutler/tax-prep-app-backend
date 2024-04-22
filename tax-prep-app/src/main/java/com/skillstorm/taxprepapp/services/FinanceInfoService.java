package com.skillstorm.taxprepapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.taxprepapp.models.FinanceInfo;
import com.skillstorm.taxprepapp.repositories.FinanceInfoRepository;

@Service
public class FinanceInfoService extends BaseService<FinanceInfo> {

    @Override
    public boolean isValidForCreate(FinanceInfo info) {
        return info.getId() == null && info.getFilingStatus() != null && info.getSpouseFirstName() != null
                && info.getSpouseMiddleInitial() != null && info.getSpouseLastName() != null
                && info.getSpouseSsn() != null && info.getW2Income() != null && info.getOtherIncome() != null
                && info.getTaxWithheldW2() != null && info.getTaxWithheld1099() != null
                && info.getTaxWithheldOther() != null && info.getPrevTaxesPaid() != null && info.getProfile() != null;
    }

    @Override
    public boolean isValidForUpdate(Integer id, FinanceInfo info) {
        if (id != null && info.getId() == null) {
            info.setId(id);
            return true;
        }
        return false;
    }

    @Autowired
    void setRepository(FinanceInfoRepository repository) {
        this.repository = repository;
    }

}
