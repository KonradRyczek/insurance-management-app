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
@Table(name = "NNW")
public class NNW {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long NNWId;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @Column(nullable = false)
    private LocalDate insuranceStartDate;

    public NNW(Client client, LocalDate insuranceStartDate) {
        this.client = client;
        this.insuranceStartDate = insuranceStartDate;
    }

    @Override
    public String toString() {
        return "NNW: " +
                client.toString() + insuranceStartDate;
    }
}
