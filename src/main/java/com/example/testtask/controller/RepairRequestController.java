package com.example.testtask.controller;

import com.example.testtask.model.RepairRequest;
import com.example.testtask.service.RepairRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RepairRequestController {

    private final RepairRequestService repairRequestService;

    @Autowired
    public RepairRequestController(RepairRequestService repairRequestService) {
        this.repairRequestService = repairRequestService;
    }

    @PostMapping(value = "/request")
    public ResponseEntity<?> create(@RequestBody RepairRequest repairRequest) {
        repairRequestService.create(repairRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/request/{id}")
    public ResponseEntity<RepairRequest> view(@PathVariable(name = "id") int id) {
        final RepairRequest repairRequest = repairRequestService.view(id);
        return repairRequest != null
                ? new ResponseEntity<>(repairRequest, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/request/{id}")
    public ResponseEntity<?> change(@PathVariable(name = "id") int id, @RequestBody RepairRequest repairRequest) {
        final boolean changed = repairRequestService.change(repairRequest, id);
        return changed
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/request/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = repairRequestService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
