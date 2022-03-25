package com.ima.insurancemanagementapp.service;

import com.ima.insurancemanagementapp.model.insurance.*;
import com.ima.insurancemanagementapp.repository.insurance.*;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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

    public OC saveOC(OC oc) {
        if (null != oc)
            ocRepository.save(oc);
        return oc;
    }
    public OCAC saveOCAC(OCAC ocac) {
        if (null != ocac)
            ocacRepository.save(ocac);
        return ocac;
    }
    public OCF saveOCF(OCF ocf) {
        if (null != ocf)
            ocfRepository.save(ocf);
        return ocf;
    }
    public OCP saveOCP(OCP ocp) {
        if (null != ocp)
            ocpRepository.save(ocp);
        return ocp;
    }
    public OCS saveOCS(OCS ocs) {
        if (null != ocs)
            ocsRepository.save(ocs);
        return ocs;
    }
    public OCZ saveOCZ(OCZ ocz) {
        if (null != ocz)
            oczRepository.save(ocz);
        return ocz;
    }
    public ND saveND(ND nd) {
        if (null != nd)
            ndRepository.save(nd);
        return nd;
    }
    public NM saveNM(NM nm) {
        if (null != nm)
            nmRepository.save(nm);
        return nm;
    }
    public NNW saveNNW(NNW nnw) {
        if (null != nnw)
            nnwRepository.save(nnw);
        return nnw;
    }

//    public ND deleteND(Long ndId) throws SQLException {
//        ND nd = ndRepository.getById(ndId);
//        if (nd != null) {
//            ndRepository.deleteById(ndId);
//        }
//        return nd;
//    }
//    public ND deleteND(Long ndId) throws SQLException {
//        ND nd = ndRepository.getById(ndId);
//        if (nd != null) {
//            ndRepository.deleteById(ndId);
//        }
//        return nd;
//    }
//    public ND deleteND(Long ndId) throws SQLException {
//        ND nd = ndRepository.getById(ndId);
//        if (nd != null) {
//            ndRepository.deleteById(ndId);
//        }
//        return nd;
//    }
//    public ND deleteND(Long ndId) throws SQLException {
//        ND nd = ndRepository.getById(ndId);
//        if (nd != null) {
//            ndRepository.deleteById(ndId);
//        }
//        return nd;
//    }
//    public ND deleteND(Long ndId) throws SQLException {
//        ND nd = ndRepository.getById(ndId);
//        if (nd != null) {
//            ndRepository.deleteById(ndId);
//        }
//        return nd;
//    }
//    public ND deleteND(Long ndId) throws SQLException {
//        ND nd = ndRepository.getById(ndId);
//        if (nd != null) {
//            ndRepository.deleteById(ndId);
//        }
//        return nd;
//    }
//    public ND deleteND(Long ndId) throws SQLException {
//        ND nd = ndRepository.getById(ndId);
//        if (nd != null) {
//            ndRepository.deleteById(ndId);
//        }
//        return nd;
//    }
//    public ND deleteND(Long ndId) throws SQLException {
//        ND nd = ndRepository.getById(ndId);
//        if (nd != null) {
//            ndRepository.deleteById(ndId);
//        }
//        return nd;
//    }
//    public ND deleteND(Long ndId) throws SQLException {
//        ND nd = ndRepository.getById(ndId);
//        if (nd != null) {
//            ndRepository.deleteById(ndId);
//        }
//        return nd;
//    }


    public ArrayList<OC> getAllOC() {
        return new ArrayList<>(ocRepository.findAll());
    }
    public ArrayList<OCAC> getAllOCAC() {
        return new ArrayList<>(ocacRepository.findAll());
    }
    public ArrayList<OCF> getAllOCF() {
        return new ArrayList<>(ocfRepository.findAll());
    }
    public ArrayList<OCP> getAllOCP() {
        return new ArrayList<>(ocpRepository.findAll());
    }
    public ArrayList<OCS> getAllOCS() {
        return new ArrayList<>(ocsRepository.findAll());
    }public ArrayList<OCZ> getAllOCZ() {
        return new ArrayList<>(oczRepository.findAll());
    }
    public ArrayList<ND> getAllND() {
        return new ArrayList<>(ndRepository.findAll());
    }
    public ArrayList<NM> getAllNM() {
        return new ArrayList<>(nmRepository.findAll());
    }
    public ArrayList<NNW> getAllNNW() {
        return new ArrayList<>(nnwRepository.findAll());
    }

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
