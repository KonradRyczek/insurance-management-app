package com.ima.insurancemanagementapp.email;

import com.ima.insurancemanagementapp.model.insurance.ND;
import com.ima.insurancemanagementapp.model.insurance.OC;
import com.ima.insurancemanagementapp.service.InsuranceService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class EmailReminderManager {

    private final SmtpEmailService smtpEmailService;

    private final InsuranceService insuranceService;

    private int reminderDaysOffset = 14;

    public EmailReminderManager(SmtpEmailService smtpEmailService, InsuranceService insuranceService) {
        this.smtpEmailService = smtpEmailService;
        this.insuranceService = insuranceService;
    }

    public void sendReminders() {
        ArrayList<OC> ocInsurances = new ArrayList<>(insuranceService.getOCbyDate(LocalDate.now()));
        System.out.println(ocInsurances.get(0).toString());
        smtpEmailService.sendMail(ocInsurances.get(0).toString());
        // check date
        // get data
        // data to string
        // send mail
    }
    /*
    Temat - T
    Treść - t

T:  Nieruchomość dom - Imie Nazwisko: Adres, RokWybud, Pietro?, Data
t:  (email)
T:  Nieruchomość mieszkanie - Imie Nazwisko: Adres, RokWybud, Pietro, Data
t:  (email)
T:  NNW - Imie Nazwisko: Data
t:  (email)
T:  OC - Imie Nazwisko: Rejestracja, RokProd, Data
t:  (email)
...
    OCAC - Imie Nazwisko (email): Rejestracja, RokProd, Data
    OCF - Imie Nazwisko (email): PKD, Obrót, Data
    OCP - Imie Nazwisko (email): IlAut, Obrót, Data
    OCS - Imie Nazwisko (email): IlAut, Obrót, Data
    OCZ - Imie Nazwisko (email): PKD, Obrót, Data


     */



}
