package com.ima.insurancemanagementapp.repository.insurance;

import com.ima.insurancemanagementapp.model.insurance.OC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OCRepository extends JpaRepository<OC, Long> {

    List<OC> findByInsuranceStartDateIs(LocalDate insuranceStartDate);

}
