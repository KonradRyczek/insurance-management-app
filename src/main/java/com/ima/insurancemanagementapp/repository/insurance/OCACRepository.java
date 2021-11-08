package com.ima.insurancemanagementapp.repository.insurance;

import com.ima.insurancemanagementapp.model.insurance.OCAC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OCACRepository extends JpaRepository<OCAC, Long> {
}
