package com.grayb.maintanencerequestserver.Domain.maintenanceRequest.repos;

import com.grayb.maintanencerequestserver.Domain.maintenanceRequest.models.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaintenanceRequestRepo extends JpaRepository <MaintenanceRequest, Long>{


        Optional<MaintenanceRequest> findByEmail(String email);
    }

