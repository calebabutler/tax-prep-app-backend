package com.skillstorm.taxprepapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.taxprepapp.models.FinanceInfo;
import com.skillstorm.taxprepapp.services.FinanceInfoService;

@RestController
@RequestMapping("/finances")
public class FinanceInfoController extends BaseController<FinanceInfo> {

    @Autowired
    void setService(FinanceInfoService service) {
        this.service = service;
    }

}
