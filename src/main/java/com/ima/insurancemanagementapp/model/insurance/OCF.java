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
@Table(name = "OCF")
public class OCF {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long OCFId;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @Column(nullable = false)
    private LocalDate insuranceStartDate;

    @Column(nullable = false)
    private BigDecimal revenue;

    @Column(nullable = false)
    private String PKD;

    public OCF(Client client, LocalDate insuranceStartDate, BigDecimal revenue, String PKD) {
        this.client = client;
        this.insuranceStartDate = insuranceStartDate;
        this.revenue = revenue;
        this.PKD = PKD;
    }
}
