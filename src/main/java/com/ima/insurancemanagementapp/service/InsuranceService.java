package com.ima.insurancemanagementapp.service;

import com.ima.insurancemanagementapp.model.client.Client;
import com.ima.insurancemanagementapp.model.insurance.ND;
import com.ima.insurancemanagementapp.model.insurance.OC;
import com.ima.insurancemanagementapp.repository.insurance.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class InsuranceService {

    private final NDRepository ndRepository;

    private final NMRepository nmRepository;

    private final NNWRepository nnwRepository;

    private final OCACRepository ocacRepository;

    private final OCFRepository ocfRepository;

    private final OCPRepository ocpRepository;

    private final OCRepository ocRepository;

    private final OCSRepository ocsRepository;

    private final OCZRepository oczRepository;


    public ArrayList<ND> getNDbyDate(LocalDate insuranceStartDate){
        return new ArrayList<>(ndRepository.findByInsuranceStartDateIs(insuranceStartDate));
    }

    public ArrayList<OC> getOCbyDate(LocalDate insuranceStartDate){
        return new ArrayList<>(ocRepository.findByInsuranceStartDateIs(insuranceStartDate));
    }


    public InsuranceService(NDRepository ndRepository, NMRepository nmRepository, NNWRepository nnwRepository, OCACRepository ocacRepository, OCFRepository ocfRepository, OCPRepository ocpRepository, OCRepository ocRepository, OCSRepository ocsRepository, OCZRepository oczRepository) {
        this.ndRepository = ndRepository;
        this.nmRepository = nmRepository;
        this.nnwRepository = nnwRepository;
        this.ocacRepository = ocacRepository;
        this.ocfRepository = ocfRepository;
        this.ocpRepository = ocpRepository;
        this.ocRepository = ocRepository;
        this.ocsRepository = ocsRepository;
        this.oczRepository = oczRepository;
    }
}
