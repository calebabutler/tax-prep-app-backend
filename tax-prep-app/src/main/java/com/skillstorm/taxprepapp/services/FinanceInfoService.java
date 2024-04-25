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
                info.getSpouseFirstName() != null && info.getSpouseMiddleInitial() != null &&
                info.getSpouseLastName() != null && info.getSpouseSsn() != null && info.getW2Income() != null &&
                info.getOtherIncome() != null && info.getTaxWithheldW2() != null && info.getTaxWithheld1099() != null &&
                info.getTaxWithheldOther() != null && info.getPrevTaxesPaid() != null && info.getOauthId() == null) {
            info.setOauthId(oauthId);
            financeInfoRepository.save(info);
            return true;
        }
        return false;
    }

    public boolean updateInfo(String oauthId, FinanceInfo info) {
        Optional<FinanceInfo> databaseInfo = getInfo(oauthId);
        if (databaseInfo.isPresent()) {
            info.setId(databaseInfo.get().getId());
            info.setOauthId(null);
            financeInfoRepository.save(info);
            return true;
        }
        return false;
    }

}
