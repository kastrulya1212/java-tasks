package com.univ_java_task_7.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univ_java_task_7.demo.mapper.RailcarMapper;
import com.univ_java_task_7.demo.model.Railcar;
import com.univ_java_task_7.demo.model.RailcarOperation;

@Service
public class OpenService {

    @Autowired
    private RailcarMapper railcarMapper;

    public List<Railcar> getAllRailcars() {
        return railcarMapper.findAllRailcars();
    }

    public Railcar getRailcarByNum(Long railcarNum) {
        return railcarMapper.findByRailcarNum(railcarNum);
    }

    public Railcar insertRailcar(Railcar railcar) {
        railcarMapper.insertRailcar(railcar);
        return railcar;
    }

    public Railcar updateRailcar(Long railcarNum, Railcar railcar) {
        Railcar oldRailcar = railcarMapper.findByRailcarNum(railcarNum);
        if (oldRailcar == null) {
            return null;
        }

        railcarMapper.updateRailcar(
                railcarNum,
                railcar.getRailcar_type(),
                railcar.getRailcar_capacity_tons(),
                railcar.getRailcar_owner_company()
        );

        return railcarMapper.findByRailcarNum(railcarNum);
    }

    public boolean deleteRailcar(Long railcarNum) {
        Railcar railcar = railcarMapper.findByRailcarNum(railcarNum);
        if (railcar == null) {
            return false;
        }

        railcarMapper.deleteByRailcarNum(railcarNum);
        return true;
    }

    public List<RailcarOperation> getAllOperations() {
        return railcarMapper.findAllOperations();
    }

    public RailcarOperation getOperationById(Long id) {
        return railcarMapper.findOperationById(id);
    }

    public List<RailcarOperation> getOperationsByRailcarNum(Long railcarNum) {
        return railcarMapper.findOperationsByRailcarNum(railcarNum);
    }

    public List<RailcarOperation> getOperationsByType(String operationType) {
        return railcarMapper.findOperationsByOperationType(operationType);
    }

    public RailcarOperation insertOperation(RailcarOperation railcarOperation) {
        railcarMapper.insertRailcarOperation(railcarOperation);
        return railcarOperation;
    }

    public RailcarOperation updateOperation(Long id, RailcarOperation railcarOperation) {
        RailcarOperation oldRailcarOperation = railcarMapper.findOperationById(id);
        if (oldRailcarOperation == null) {
            return null;
        }

        railcarMapper.updateRailcarOperation(
                id,
                railcarOperation.getOperation_type(),
                railcarOperation.getOperation_status(),
                railcarOperation.getStation_from(),
                railcarOperation.getStation_to()
        );

        return railcarMapper.findOperationById(id);
    }

    public boolean deleteOperation(Long id) {
        RailcarOperation railcarOperation = railcarMapper.findOperationById(id);
        if (railcarOperation == null) {
            return false;
        }

        railcarMapper.deleteRailcarOperationById(id);
        return true;
    }
}
