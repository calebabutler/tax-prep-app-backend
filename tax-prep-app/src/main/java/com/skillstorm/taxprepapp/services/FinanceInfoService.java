package com.skillstorm.taxprepapp.services;

import com.skillstorm.taxprepapp.models.FinanceInfo;
import com.skillstorm.taxprepapp.repositories.FinanceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinanceInfoService {

    @Autowired
    FinanceInfoRepository financeInfoRepository;

    public Optional<FinanceInfo> getInfo(String oauthId) {
        List<FinanceInfo> infos = financeInfoRepository.findByOauthId(oauthId);
        if (infos.isEmpty()) {
            return Optional.empty();
        }
        FinanceInfo info = infos.get(0);
        info.setId(null);
        info.setOauthId(null);
        return Optional.of(info);
    }

    /* Returns whether it was successful or not */
    public boolean createInfo(String oauthId, FinanceInfo info) {
        if (getInfo(oauthId).isEmpty() && info.getId() == null && info.getFilingStatus() != null &&
                info.getW2Income() != null &&
                info.getOtherIncome() != null && info.getTaxWithheldW2() != null && info.getTaxWithheld1099() != null &&
                info.getTaxWithheldOther() != null && info.getPrevTaxesPaid() != null) {
            info.setOauthId(oauthId);
            financeInfoRepository.save(info);
            return true;
        }
        return false;
    }

    public boolean updateInfo(String oauthId, FinanceInfo info) {
        List<FinanceInfo> infos = financeInfoRepository.findByOauthId(oauthId);
        if (infos.isEmpty()) {
            return false;
        }
        FinanceInfo databaseInfo = infos.get(0);
        databaseInfo.setFilingStatus(info.getFilingStatus());
        databaseInfo.setSpouseFirstName(info.getSpouseFirstName());
        databaseInfo.setSpouseMiddleInitial(info.getSpouseMiddleInitial());
        databaseInfo.setSpouseLastName(info.getSpouseLastName());
        databaseInfo.setSpouseDateOfBirth(info.getSpouseDateOfBirth());
        databaseInfo.setSpouseSsn(info.getSpouseSsn());
        databaseInfo.setW2Income(info.getW2Income());
        databaseInfo.setOtherIncome(info.getOtherIncome());
        databaseInfo.setTaxWithheldW2(info.getTaxWithheldW2());
        databaseInfo.setTaxWithheld1099(info.getTaxWithheld1099());
        databaseInfo.setTaxWithheldOther(info.getTaxWithheldOther());
        databaseInfo.setPrevTaxesPaid(info.getPrevTaxesPaid());
        financeInfoRepository.save(databaseInfo);
        return true;
    }
}
