package com.ima.insurancemanagementapp.repository.insurance;

import com.ima.insurancemanagementapp.model.insurance.OCP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OCPRepository extends JpaRepository<OCP, Long> {

    List<OCP> findByInsuranceStartDateIs(LocalDate insuranceStartDate);

}
