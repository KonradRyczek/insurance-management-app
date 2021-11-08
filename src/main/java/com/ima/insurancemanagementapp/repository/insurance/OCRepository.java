package com.ima.insurancemanagementapp.repository.insurance;

import com.ima.insurancemanagementapp.model.insurance.OC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OCRepository extends JpaRepository<OC, Long> {
}
