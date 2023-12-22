package com.grayb.maintanencerequestserver.Domain.maintenanceRequest.controllers;

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
        maintenanceRequest = MaintenanceRequestService.create(maintenanceRequest);
        return new ResponseEntity<>(maintenanceRequest, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MaintenanceRequest> getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestService.getById(id);
        return new ResponseEntity<>(maintenanceRequest, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<MaintenanceRequest> getByEmail(@RequestParam String email) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = MaintenanceRequestService.getByEmail(email);
        return new ResponseEntity<>(maintenanceRequest, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<MaintenanceRequest> update(@PathVariable("id") Long id, @RequestBody MaintenanceRequest maintenanceRequestDetail) throws ResourceNotFoundException {
        maintenanceRequestDetail = MaintenanceRequestService.update(id, maintenanceRequestDetail);
        return new ResponseEntity<>(maintenanceRequestDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        maintenanceRequestService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}


