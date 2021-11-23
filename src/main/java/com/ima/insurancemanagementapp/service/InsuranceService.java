package com.ima.insurancemanagementapp.service;

import com.ima.insurancemanagementapp.model.insurance.ND;
import com.ima.insurancemanagementapp.model.insurance.OC;
import com.ima.insurancemanagementapp.repository.insurance.*;
import lombok.val;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

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


    public ArrayList<String> getNDByDate(LocalDate insuranceStartDate) {
        return new ArrayList<>(ndRepository.findByInsuranceStartDateIs(insuranceStartDate))
                .stream()
                .map(elem -> elem.toString())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getNMByDate(LocalDate insuranceStartDate) {
        return new ArrayList<>(nmRepository.findByInsuranceStartDateIs(insuranceStartDate))
                .stream()
                .map(elem -> elem.toString())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getNNWByDate(LocalDate insuranceStartDate) {
        return new ArrayList<>(nnwRepository.findByInsuranceStartDateIs(insuranceStartDate))
                .stream()
                .map(elem -> elem.toString())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getOCByDate(LocalDate insuranceStartDate) {
        return new ArrayList<>(ocRepository.findByInsuranceStartDateIs(insuranceStartDate))
                .stream()
                .map(elem -> elem.toString())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getOCACByDate(LocalDate insuranceStartDate) {
        return new ArrayList<>(ocacRepository.findByInsuranceStartDateIs(insuranceStartDate))
                .stream()
                .map(elem -> elem.toString())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getOCFByDate(LocalDate insuranceStartDate) {
        return new ArrayList<>(ocfRepository.findByInsuranceStartDateIs(insuranceStartDate))
                .stream()
                .map(elem -> elem.toString())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getOCPByDate(LocalDate insuranceStartDate) {
        return new ArrayList<>(ocpRepository.findByInsuranceStartDateIs(insuranceStartDate))
                .stream()
                .map(elem -> elem.toString())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getOCSByDate(LocalDate insuranceStartDate) {
        return new ArrayList<>(ocsRepository.findByInsuranceStartDateIs(insuranceStartDate))
                .stream()
                .map(elem -> elem.toString())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getOCZByDate(LocalDate insuranceStartDate) {
        return new ArrayList<>(oczRepository.findByInsuranceStartDateIs(insuranceStartDate))
                .stream()
                .map(elem -> elem.toString())
                .collect(Collectors.toCollection(ArrayList::new));
    }




    public InsuranceService(
            NDRepository ndRepository,
            NMRepository nmRepository,
            NNWRepository nnwRepository,
            OCACRepository ocacRepository,
            OCFRepository ocfRepository,
            OCPRepository ocpRepository,
            OCRepository ocRepository,
            OCSRepository ocsRepository,
            OCZRepository oczRepository
    ) {
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
