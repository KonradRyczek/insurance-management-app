package com.ima.insurancemanagementapp.controller.v1.api;


import com.ima.insurancemanagementapp.model.client.Client;
import com.ima.insurancemanagementapp.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/klienci")
    public String showListAllClients(Model model){
        ArrayList<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        model.addAttribute("client", new Client());

        return "klienci";
    }

    @PostMapping("/klienci")
    public String saveStudent(Client client){
        clientService.addClient(client);
        return "redirect:/klienci";
    }

    @GetMapping("/usunKlienta/{clientId}")
    public String deleteStudent(@PathVariable(value = "clientId") Long clientId) {
        clientService.deleteClient(clientId);
        return "redirect:/klienci";
    }



    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

}
