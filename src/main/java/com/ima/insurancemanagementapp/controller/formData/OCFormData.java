package com.ima.insurancemanagementapp.controller.formData;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class OCFormData {
    @NotBlank
    private String clientEmail;

    @NotBlank
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private LocalDate insuranceStartDate;

    @NotBlank
    private String vehiclePlate;

    @NotBlank
    private int vehicleYearOfProduction;
}
