package com.ima.insurancemanagementapp.repository.insurance;

import com.ima.insurancemanagementapp.model.insurance.ND;
import com.ima.insurancemanagementapp.model.insurance.OCF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OCFRepository extends JpaRepository<OCF, Long> {

    List<OCF> findByInsuranceStartDateIs(LocalDate insuranceStartDate);

}
