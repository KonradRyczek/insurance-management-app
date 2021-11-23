package com.ima.insurancemanagementapp.repository.insurance;

import com.ima.insurancemanagementapp.model.insurance.ND;
import com.ima.insurancemanagementapp.model.insurance.NNW;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NNWRepository extends JpaRepository<NNW, Long> {

    List<NNW> findByInsuranceStartDateIs(LocalDate insuranceStartDate);

}
