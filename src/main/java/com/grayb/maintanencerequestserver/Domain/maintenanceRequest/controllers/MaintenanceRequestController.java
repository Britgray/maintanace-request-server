package com.grayb.maintanencerequestserver.Domain.maintenanceRequest.controllers;

import com.grayb.maintanencerequestserver.Domain.core.exceptions.ResourceCreationException;
import com.grayb.maintanencerequestserver.Domain.core.exceptions.ResourceNotFoundException;
import com.grayb.maintanencerequestserver.Domain.maintenanceRequest.models.MaintenanceRequest;
import com.grayb.maintanencerequestserver.Domain.maintenanceRequest.services.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/maintenanceRequest")
public class MaintenanceRequestController {

    private MaintenanceRequestService maintenanceRequestService;

    @Autowired
    public MaintenanceRequestController(MaintenanceRequestService maintenanceRequests) {
        this.maintenanceRequestService = maintenanceRequestService;
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceRequest>> getAll(){
        List<MaintenanceRequest> maintenanceRequests = maintenanceRequestService.getAll();
        return new ResponseEntity<>(maintenanceRequests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MaintenanceRequest> create(@RequestBody MaintenanceRequest maintenanceRequest) {
        try {
            maintenanceRequest = maintenanceRequestService.create(maintenanceRequest);
            return new ResponseEntity<>(maintenanceRequest, HttpStatus.CREATED);
        } catch (ResourceCreationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<MaintenanceRequest> getById(@PathVariable("id") Long id) {
        try {
            MaintenanceRequest maintenanceRequest = maintenanceRequestService.getById(id);
            return new ResponseEntity<>(maintenanceRequest, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("lookup")
    public ResponseEntity<MaintenanceRequest> getByEmail(@RequestParam String email) {
        try{
            MaintenanceRequest maintenanceRequest = maintenanceRequestService.getByEmail(email);
            return new ResponseEntity<>(maintenanceRequest, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            // Handle the exception and return an appropriate response
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<MaintenanceRequest> update(@PathVariable("id") Long id, @RequestBody MaintenanceRequest maintenanceRequestDetail) {
        try {
            maintenanceRequestDetail = maintenanceRequestService.update(id, maintenanceRequestDetail);
            return new ResponseEntity<>(maintenanceRequestDetail, HttpStatus.ACCEPTED);
        } catch (ResourceNotFoundException e) {
            // Handle the exception and return an appropriate response
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try {
            maintenanceRequestService.delete(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch(ResourceNotFoundException e){
                // Handle the exception and return an appropriate response
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            }
        }