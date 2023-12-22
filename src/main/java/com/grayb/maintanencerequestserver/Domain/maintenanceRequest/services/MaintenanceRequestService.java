package com.grayb.maintanencerequestserver.Domain.maintenanceRequest.services;

import com.grayb.maintanencerequestserver.Domain.core.exceptions.ResourceCreationException;
import com.grayb.maintanencerequestserver.Domain.core.exceptions.ResourceNotFoundException;
import com.grayb.maintanencerequestserver.Domain.maintenanceRequest.models.MaintenanceRequest;


import java.time.LocalDate;
import java.util.List;
public interface MaintenanceRequestService {

    MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException;

    MaintenanceRequest getById(Long id) throws ResourceNotFoundException;

    MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException;
    MaintenanceRequest getByFirstName(String firstName) throws ResourceNotFoundException;
        MaintenanceRequest getByLastName(String lastName) throws ResourceNotFoundException;
        MaintenanceRequest getByDescription(String description) throws ResourceNotFoundException;
        MaintenanceRequest getByAptNumber(Long aptNumber) throws ResourceNotFoundException;
        MaintenanceRequest getByCreateAt(LocalDate createAt) throws ResourceNotFoundException;


    List<MaintenanceRequest> getAll();

    MaintenanceRequest update(Long id, MaintenanceRequest maintenanceRequestDetail) throws ResourceNotFoundException;


    void delete (Long id) throws ResourceNotFoundException;
    }


