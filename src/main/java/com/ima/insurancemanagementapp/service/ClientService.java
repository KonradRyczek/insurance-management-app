package com.ima.insurancemanagementapp.service;

import com.ima.insurancemanagementapp.model.client.Client;
import com.ima.insurancemanagementapp.repository.client.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ArrayList<Client> getAllClients() {
        return new ArrayList<>(clientRepository.findAll());
    }

    public Client addClient(Client clientToAdd) {
        Client client = getClient(clientToAdd.getEmail());
        if (client == null) {
            return clientRepository.save(client);
        }
        return null; //this client already exists
    }

    // TODO public Client updateClient()

    private Client getClient(String email) {
        return clientRepository.findByEmail(email);
    }
}
