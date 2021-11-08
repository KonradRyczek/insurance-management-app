package com.ima.insurancemanagementapp.repository.insurance;

import com.ima.insurancemanagementapp.model.insurance.NM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NMRepository extends JpaRepository<NM, Long> {
}
