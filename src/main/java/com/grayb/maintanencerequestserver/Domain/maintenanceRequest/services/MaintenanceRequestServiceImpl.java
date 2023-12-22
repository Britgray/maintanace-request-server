package com.grayb.maintanencerequestserver.Domain.maintenanceRequest.services;
import com.grayb.maintanencerequestserver.Domain.core.exceptions.ResourceNotFoundException;
import com.grayb.maintanencerequestserver.Domain.core.exceptions.ResourceCreationException;
import com.grayb.maintanencerequestserver.Domain.maintenanceRequest.models.MaintenanceRequest;
import com.grayb.maintanencerequestserver.Domain.maintenanceRequest.repos.MaintenanceRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

    @Service
    public class MaintenanceRequestServiceImpl implements MaintenanceRequestService {
        private MaintenanceRequestRepo maintenanceRequestRepo;
        @Autowired
        public MaintenanceRequestServiceImpl(MaintenanceRequestRepo maintenanceRequestRepo){
            this.maintenanceRequestRepo = maintenanceRequestRepo;
        }

        @Override
        public MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException {
            Optional<MaintenanceRequest> optional = maintenanceRequestRepo.findByEmail(maintenanceRequest.getEmail());
            if (optional.isPresent())
                throw new ResourceCreationException("Maintenance Request with email exists: " + maintenanceRequest.getEmail());

            maintenanceRequest = maintenanceRequestRepo.save(maintenanceRequest);
            return maintenanceRequest;
        }

        @Override
        public MaintenanceRequest getById(Long id) throws ResourceNotFoundException {
            MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException("No Maintenance Request with id: " + id));
            return maintenanceRequest;
        }

        @Override
        public MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException {
            MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findByEmail(email)
                    .orElseThrow(()->new ResourceNotFoundException("No Maintenance Request with email: " + email));
            return maintenanceRequest;
        }

        @Override
        public MaintenanceRequest getByFirstName(String firstName) throws ResourceNotFoundException {
            return null;
        }

        @Override
        public MaintenanceRequest getByLastName(String lastName) throws ResourceNotFoundException {
            return maintenanceRequest;
        }

        @Override
        public MaintenanceRequest getByDescription(String description) throws ResourceNotFoundException {
            return maintenanceRequest;
        }

        @Override
        public MaintenanceRequest getByAptNumber(int aptNumber) throws ResourceNotFoundException {
            return maintenanceRequest;
        }

        @Override
        public MaintenanceRequest getByCreateAt(LocalDate createAt) throws ResourceNotFoundException {
            return maintenanceRequest;
        }

        @Override
        public List<MaintenanceRequest> getAll() {
            return maintenanceRequestRepo.findAll();
        }

        @Override
        public MaintenanceRequest update(Long id, MaintenanceRequest maintenanceRequestDetail) throws ResourceNotFoundException {
            MaintenanceRequest maintenanceRequest = getById(id);
            maintenanceRequest.setFirstName(maintenanceRequestDetail.getFirstName());
            maintenanceRequest.setLastName(maintenanceRequestDetail.getLastName());
            maintenanceRequest.setEmail(maintenanceRequestDetail.getEmail());
            maintenanceRequest = maintenanceRequestRepo.save(maintenanceRequest);
            return maintenanceRequest;
        }

        @Override
        public void delete(Long id) {
            MaintenanceRequest maintenanceRequest = getById(id);
            maintenanceRequestRepo.delete(maintenanceRequest);
        }
    }




