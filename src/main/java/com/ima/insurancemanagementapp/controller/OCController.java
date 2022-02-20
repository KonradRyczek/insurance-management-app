package com.ima.insurancemanagementapp.controller;

import com.ima.insurancemanagementapp.controller.formData.OCFormData;
import com.ima.insurancemanagementapp.model.client.Client;
import com.ima.insurancemanagementapp.model.insurance.OC;
import com.ima.insurancemanagementapp.service.ClientService;
import com.ima.insurancemanagementapp.service.InsuranceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class OCController {

    private final InsuranceService insuranceService;
    private final ClientService clientService;

    @GetMapping(value = "/OC")
    public ModelAndView ocDetailsPage() {
        ModelAndView modelAndView = new ModelAndView("OC");
        modelAndView.addObject("ocList", insuranceService.getAllOC());
        modelAndView.addObject("ocFormData", new OCFormData());
        return modelAndView;
    }

    @PostMapping(value = "/OC")
    public ModelAndView addOC(@Valid @ModelAttribute("ocFormData")OCFormData ocFormData, ModelAndView modelAndView ) {
        Client client = clientService.findClientByEmail(ocFormData.getClientEmail());
        if (null != client) {
            insuranceService.saveOC(
                    new OC(client,
                            ocFormData.getInsuranceStartDate(),
                            ocFormData.getVehiclePlate(),
                            ocFormData.getVehicleYearOfProduction()));
        }
        modelAndView.addObject("ocList", insuranceService.getAllOC());
        modelAndView.addObject("ocFormData", new OCFormData());
        return modelAndView;
    }

    @GetMapping(value = "/OC/usunOC/{OCId}")
    public ModelAndView deleteOC(@PathVariable(value = "ocId") Long ocId, ModelAndView modelAndView) {
        return modelAndView;
    }


    public OCController(InsuranceService insuranceService, ClientService clientService) {
        this.insuranceService = insuranceService;
        this.clientService = clientService;
    }
}
