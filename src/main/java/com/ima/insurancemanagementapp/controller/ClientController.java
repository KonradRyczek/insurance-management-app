package com.ima.insurancemanagementapp.controller;
import com.ima.insurancemanagementapp.model.client.Client;
import com.ima.insurancemanagementapp.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        if (client != null)
            clientService.addClient(client);
        return "redirect:/klienci";
    }

    @GetMapping("/klienci/usunKlienta/{clientId}")
    public String deleteStudent(@PathVariable(value = "clientId") Long clientId) {
        try {
            if (clientId != null)
                clientService.deleteClient(clientId);

            return "redirect:/klienci";

        } catch (Exception e) {
            return "redirect:/klienci";
        }

    }

    @GetMapping("/edytujKlienta/{clientEmail}")
    public String getEditClientForm(Model model, @PathVariable(value = "clientEmail") String clientEmail) {
        if (clientEmail.isBlank())
            return "redirect:/klienci";
        model.addAttribute("client", new Client());
        model.addAttribute("clientEmail");
        contextVariables.put("clientEmail", clientEmail);
        return "edytujKlienta";
    }


    @PostMapping("/edytujKlienta")
    public String editClient(Client client) {
        try {
            String clientEmail = contextVariables.get("clientEmail");
            if (!clientEmail.isBlank())
                clientService.editClient(clientEmail, client);
            return "redirect:/klienci";

        } catch (Exception e) {
            return "redirect:/klienci";
        }
    }



    private Map<String, String> contextVariables = new HashMap<>();

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

}
