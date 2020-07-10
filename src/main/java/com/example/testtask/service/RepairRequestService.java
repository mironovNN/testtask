package com.example.testtask.service;

import com.example.testtask.model.RepairRequest;

public interface RepairRequestService {

    void create(RepairRequest repairRequest);

    RepairRequest view(int id);

    boolean change(RepairRequest repairRequest, int id);

    boolean delete(int id);

}
