package com.ima.insurancemanagementapp.service;

import com.ima.insurancemanagementapp.model.client.Client;
import com.ima.insurancemanagementapp.repository.client.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

@Transactional
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ArrayList<Client> getAllClients() {
        return new ArrayList<>(clientRepository.findAll());
    }

    public Client addClient(Client clientToAdd) {
        Client client = getClient(clientToAdd.getEmail());
        if (client == null) {
            //System.out.println("addClient: client= "+clientToAdd);
            return clientRepository.save(clientToAdd);
        }
        return null; //this client already exists
    }

    public void deleteClient(Long clientId) throws SQLException {
        Client client = clientRepository.getById(clientId);
        if (client != null) {
            //System.out.println("Delete by clientid: clientId= "+clientId);
            clientRepository.deleteById(clientId);
        }
    }


//
//    public Client updateClient(String email, Client newClient) {
//        Optional<Client> client = Optional.ofNullable(clientRepository.findByEmail(email));
//        if (client.isPresent()) {
//            Client clientModel = client.get();
//            clientModel.setFirstName(newClient.getFirstName())
//                    .setLastName(newClient.getLastName())
//                    .setEmail(newClient.getEmail())
//                    .setDriverLicenseIssueDate(newClient.getDriverLicenseIssueDate());
//            return clientRepository.save(clientModel);
//        }
//        return null;
//    }

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    private Client getClient(String email) {
        return clientRepository.findByEmail(email);
    }

}
