package com.ima.insurancemanagementapp.repository.client;

import com.ima.insurancemanagementapp.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail(String email);

    Client deleteClientBy(String email);

}
