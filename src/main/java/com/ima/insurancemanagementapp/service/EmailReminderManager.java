package com.ima.insurancemanagementapp.service;

import com.ima.insurancemanagementapp.component.email.SmtpEmailService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class EmailReminderManager {

    private final SmtpEmailService smtpEmailService;

    private final InsuranceService insuranceService;

    private int reminderDaysOffset = 14;

    public EmailReminderManager(SmtpEmailService smtpEmailService, InsuranceService insuranceService) {
        this.smtpEmailService = smtpEmailService;
        this.insuranceService = insuranceService;
    }

    public void sendReminders() {
        ArrayList<String> insurances = new ArrayList<>();
        LocalDate daysOffset = LocalDate.now();
        insurances.addAll(insuranceService.getNDByDate(daysOffset));
        insurances.addAll(insuranceService.getNMByDate(daysOffset));
        insurances.addAll(insuranceService.getNNWByDate(daysOffset));
        insurances.addAll(insuranceService.getOCByDate(daysOffset));
        insurances.addAll(insuranceService.getOCACByDate(daysOffset));
        insurances.addAll(insuranceService.getOCFByDate(daysOffset));
        insurances.addAll(insuranceService.getOCPByDate(daysOffset));
        insurances.addAll(insuranceService.getOCSByDate(daysOffset));
        insurances.addAll(insuranceService.getOCZByDate(daysOffset));

        for (String elem: insurances) {
            System.out.println(elem);
            //smtpEmailService.sendMail(elem);
        }

    }

}
