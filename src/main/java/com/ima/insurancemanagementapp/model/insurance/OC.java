package com.ima.insurancemanagementapp.model.insurance;

import com.ima.insurancemanagementapp.model.client.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "OC")
public class OC {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long OCId;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @Column(nullable = false)
    private LocalDate insuranceStartDate;

    @Column(nullable = false)
    private String vehiclePlate;

    @Column(nullable = false)
    private int vehicleYearOfProduction;

    public OC(Client client, LocalDate insuranceStartDate, String vehiclePlate, int vehicleYearOfProduction) {
        this.client = client;
        this.insuranceStartDate = insuranceStartDate;
        this.vehiclePlate = vehiclePlate;
        this.vehicleYearOfProduction = vehicleYearOfProduction;
    }
}
