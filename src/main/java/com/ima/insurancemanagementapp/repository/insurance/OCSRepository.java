package com.ima.insurancemanagementapp.repository.insurance;

import com.ima.insurancemanagementapp.model.insurance.OCS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OCSRepository extends JpaRepository<OCS, Long> {

    List<OCS> findByInsuranceStartDateIs(LocalDate insuranceStartDate);

}
