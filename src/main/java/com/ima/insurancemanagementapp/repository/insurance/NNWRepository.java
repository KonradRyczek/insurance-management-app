package com.ima.insurancemanagementapp.repository.insurance;

import com.ima.insurancemanagementapp.model.insurance.NNW;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NNWRepository extends JpaRepository<NNW, Long> {

}
