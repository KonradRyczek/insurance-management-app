package com.ima.insurancemanagementapp.service;

import com.ima.insurancemanagementapp.model.client.Client;
import com.ima.insurancemanagementapp.repository.client.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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
            return clientRepository.save(clientToAdd);
        }
        return null; //this client already exists
    }

    public Client deleteClient(String email) {
        Client client = getClient(email);
        if (client != null) {
            return clientRepository.deleteClientBy(client.getEmail());
        }
        return null;
    }

    public Client updateClient(String email, Client newClient) {
        Optional<Client> client = Optional.ofNullable(clientRepository.findByEmail(email));
        if (client.isPresent()) {
            Client clientModel = client.get();
            clientModel.setFirstName(newClient.getFirstName())
                    .setLastName(newClient.getLastName())
                    .setEmail(newClient.getEmail())
                    .setDriverLicenseIssueDate(newClient.getDriverLicenseIssueDate());
            return clientRepository.save(clientModel);
        }
        return null;
    }

    private Client getClient(String email) {
        return clientRepository.findByEmail(email);
    }
}
