package com.ima.insurancemanagementapp.controller.v1.api;


import com.ima.insurancemanagementapp.model.client.Client;
import com.ima.insurancemanagementapp.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clientsList")
    public String showListAllClients(Model model){
        ArrayList<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "clientsList";
    }

    @GetMapping(value = "/addClient")
    public String addStudent(Model model) {
        model.addAttribute("client", new Client());
        return "addClient";
    }

    @PostMapping(value = "/addClient")
    public void saveStudent(Client client) {
        System.out.println("/addClient");
        System.out.println(client);
        clientService.addClient(client);
        //return "clientsList"; nie działa, trzeba zrobić przekierowanie do listy klientów
    }
}
