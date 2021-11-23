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
@Table(name = "NM")
public class NM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long NMId;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @Column(nullable = false)
    private LocalDate insuranceStartDate;

    @Column(nullable = false)
    private String buildingAddress;

    @Column(nullable = false)
    private int buildingBuildYear;

    @Column(nullable = false)
    private boolean isItFlammable;

//    @Enumerated(EnumType.STRING)
//    Floor floor;

    @Override
    public String toString() {
        return "Nieruchomość Mieszkanie - " +
                "client=" + client.toString() +
                buildingAddress + " " + insuranceStartDate;
    }
}
