package com.grayb.maintanencerequestserver.Domain.maintenanceRequest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class MaintenanceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    private String lastName;

    private String email;

    private Long aptNumber;

    private String description;

    private LocalDate createAt;

    public String toString() {
        return String.format("%d %s %s %s %d %s %s", id, firstName, lastName, email, aptNumber, description, createAt);
    }
}