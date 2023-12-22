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
            Optional<MaintenanceRequest> existingRequest = maintenanceRequestRepo.findByEmail(maintenanceRequest.getEmail());
            if (existingRequest.isPresent()){
                throw new ResourceCreationException("Maintenance Request with email exists: " + maintenanceRequest.getEmail());
        }
            return maintenanceRequestRepo.save(maintenanceRequest);
        }

        @Override
        public MaintenanceRequest getById(Long id) throws ResourceNotFoundException {
            return maintenanceRequestRepo.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException("No Maintenance Request with id: " + id));

        }

        @Override
        public MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException {
            return maintenanceRequestRepo.findByEmail(email)
                    .orElseThrow(()->new ResourceNotFoundException("No Maintenance Request with email: " + email));
        }
        @Override
        public MaintenanceRequest getByFirstName(String firstName) throws ResourceNotFoundException {
            return maintenanceRequestRepo.findByEmail(firstName)
                    .orElseThrow(()->new ResourceNotFoundException("No Maintenance Request with first name: " + firstName));
        }
        @Override
        public MaintenanceRequest getByLastName(String lastName) throws ResourceNotFoundException {
            return maintenanceRequestRepo.findByEmail(lastName)
                    .orElseThrow(()->new ResourceNotFoundException("No Maintenance Request with last name: " + lastName));
        }
        @Override
        public MaintenanceRequest getByDescription(String description) throws ResourceNotFoundException {
            return maintenanceRequestRepo.findByEmail(description)
                    .orElseThrow(()->new ResourceNotFoundException("No Maintenance Request with description: " + description));
        }
        @Override
        public MaintenanceRequest getByAptNumber(Long aptNumber) throws ResourceNotFoundException {
            return maintenanceRequestRepo.findById(aptNumber)
                    .orElseThrow(()->new ResourceNotFoundException("No Maintenance Request with apt number: " + aptNumber));

        }
        @Override
        public MaintenanceRequest getByCreateAt(LocalDate localDate) throws ResourceNotFoundException {
            return maintenanceRequestRepo.findByCreateAt(localDate)
                    .orElseThrow(()->new ResourceNotFoundException("No Maintenance Request with creation date " + localDate));

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
            return maintenanceRequestRepo.save(maintenanceRequest);

        }

        @Override
        public void delete(Long id) throws ResourceNotFoundException {
            MaintenanceRequest maintenanceRequest = getById(id);
            maintenanceRequestRepo.delete(maintenanceRequest);
        }
    }




