package com.ima.insurancemanagementapp;

import com.ima.insurancemanagementapp.model.client.Client;
import com.ima.insurancemanagementapp.repository.client.ClientRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    private ClientRepository clientRepository;

    public DataLoader(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void run(ApplicationArguments args) {
        clientRepository.save(new Client("Konrad", "Ryczek", "moj@email.com", LocalDate.now().minusDays(1)));
        clientRepository.save(new Client("Mariusz", "Perek", "mariusz@email.com", LocalDate.now()));
        clientRepository.save(new Client("Ilona", "Mik", "mik@email.com", LocalDate.now().minusDays(15)));
        clientRepository.save(new Client("Peter", "Johannes", "peterek@email.com", LocalDate.now().minusMonths(22)));
        clientRepository.save(new Client("Iwona", "Pawlik", "iwona@email.com", LocalDate.now().minusWeeks(33)));
    }
}

