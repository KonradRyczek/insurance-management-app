package com.ima.insurancemanagementapp.repository.insurance;

import com.ima.insurancemanagementapp.model.insurance.ND;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NDRepository extends JpaRepository<ND, Long> {

    List<ND> findByInsuranceStartDateIs(LocalDate insuranceStartDate);

}
