package com.ima.insurancemanagementapp.model.insurance;

import com.ima.insurancemanagementapp.model.client.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "OCP")
public class OCP {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long OCPId;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @Column(nullable = false)
    private LocalDate insuranceStartDate;

    @Column(nullable = false)
    private BigDecimal revenue;

    @Column(nullable = false)
    private int amountOfVehicles;

    public OCP(Client client, LocalDate insuranceStartDate, BigDecimal revenue, int amountOfVehicles) {
        this.client = client;
        this.insuranceStartDate = insuranceStartDate;
        this.revenue = revenue;
        this.amountOfVehicles = amountOfVehicles;
    }

    @Override
    public String toString() {
        return "OCP: " +
                client.toString() + " " +
                revenue + " " +
                amountOfVehicles + " " +
                insuranceStartDate;
    }
}
