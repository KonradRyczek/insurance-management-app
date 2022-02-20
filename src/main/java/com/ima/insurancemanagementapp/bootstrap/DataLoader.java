package com.ima.insurancemanagementapp.bootstrap;

import com.ima.insurancemanagementapp.model.client.Client;
import com.ima.insurancemanagementapp.model.insurance.OC;
import com.ima.insurancemanagementapp.repository.client.ClientRepository;
import com.ima.insurancemanagementapp.repository.insurance.NDRepository;
import com.ima.insurancemanagementapp.repository.insurance.OCRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    private ClientRepository clientRepository;

    private NDRepository ndRepository;

    private OCRepository ocRepository;

    public DataLoader(ClientRepository clientRepository, NDRepository ndRepository, OCRepository ocRepository) {
        this.clientRepository = clientRepository;
        this.ndRepository = ndRepository;
        this.ocRepository = ocRepository;
    }

    public void run(ApplicationArguments args) {
        /*
        clientRepository.save(new Client("Konrad", "Ryczek", "moj@email.com", LocalDate.now().minusDays(1)));
        clientRepository.save(new Client("Mariusz", "Perek", "mariusz@email.com", LocalDate.now()));
        clientRepository.save(new Client("Ilona", "Mik", "mik@email.com", LocalDate.now().minusDays(15)));
        clientRepository.save(new Client("Peter", "Johannes", "peterek@email.com", LocalDate.now().minusMonths(22)));
        clientRepository.save(new Client("Iwona", "Pawlik", "iwona@email.com", LocalDate.now().minusWeeks(33)));
        */

        Client c = clientRepository.save(new Client("Mona", "Gerges", "mona@email.com", LocalDate.now()));
        clientRepository.save(new Client("Alczan", "Potasu", "alpo@.com", LocalDate.now()));

        ocRepository.save(new OC(c, LocalDate.now(), "SG0032W", 1999));
        ocRepository.save(new OC(c, LocalDate.now(), "SK02344", 1999));
    }
}

