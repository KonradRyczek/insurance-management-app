package com.ima.insurancemanagementapp.repository.insurance;

import com.ima.insurancemanagementapp.model.insurance.OCZ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OCZRepository extends JpaRepository<OCZ, Long> {

    List<OCZ> findByInsuranceStartDateIs(LocalDate insuranceStartDate);

}
