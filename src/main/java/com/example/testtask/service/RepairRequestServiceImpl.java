package com.example.testtask.service;

import com.example.testtask.model.RepairRequest;
import com.example.testtask.repository.RepairRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class RepairRequestServiceImpl implements RepairRequestService {

    private final RepairRequestRepository repairRequestRepository;

    public RepairRequestServiceImpl(RepairRequestRepository repairRequestRepository) {
        this.repairRequestRepository = repairRequestRepository;
    }

    @Override
    public void create(RepairRequest repairRequest) {
        repairRequestRepository.save(repairRequest);
    }

    @Override
    public RepairRequest view(int id) {
        return repairRequestRepository.getOne(id);
    }

    public boolean change(RepairRequest repairRequest, int id){

        if (repairRequestRepository.existsById(id)) {
            repairRequest.setId(id);
            repairRequestRepository.save(repairRequest);
            return true;
        }

        return false;
    }

    public boolean delete(int id){
        if (repairRequestRepository.existsById(id)) {
            repairRequestRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
