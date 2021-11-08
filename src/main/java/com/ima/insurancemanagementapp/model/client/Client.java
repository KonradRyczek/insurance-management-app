package com.ima.insurancemanagementapp.model.client;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
/*
corresponds to SQL DATE which means it stores years, months and days while hour, minute, second and millisecond are ignored.
 Additionally, sql.Date isn't tied to timezones.
 */

@ToString // delete later
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clientId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate driverLicenseIssueDate;

    public Client(String firstName, String lastName, String email, LocalDate driverLicenseIssueDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.driverLicenseIssueDate = driverLicenseIssueDate;
    }
}
