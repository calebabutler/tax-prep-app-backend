package com.skillstorm.taxprepapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.taxprepapp.models.FinanceInfo;

import java.util.List;

@Repository
public interface FinanceInfoRepository extends JpaRepository<FinanceInfo, Integer> {
    List<FinanceInfo> findByOauthId(String oauthId);
}
