package com.univ_java_task_7.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.univ_java_task_7.demo.model.Railcar;
import com.univ_java_task_7.demo.model.RailcarOperation;
import com.univ_java_task_7.demo.service.OpenService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Railcars")
public class OpenController {

    @Autowired
    private OpenService openService;

    @GetMapping("/railcars")
    @Operation(summary = "Get all railcars")
    public List<Railcar> getAllRailcars() {
        return openService.getAllRailcars();
    }

    @GetMapping("/railcars/{railcarNum}")
    @Operation(summary = "Get railcar by number")
    public ResponseEntity<?> getRailcarByNum(@PathVariable Long railcarNum) {
        Railcar railcar = openService.getRailcarByNum(railcarNum);
        if (railcar == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(railcar);
    }

    @PostMapping("/railcars")
    @Operation(summary = "Insert railcar")
    public Railcar insertRailcar(@RequestBody Railcar railcar) {
        return openService.insertRailcar(railcar);
    }

    @PutMapping("/railcars/{railcarNum}")
    @Operation(summary = "Update railcar")
    public ResponseEntity<?> updateRailcar(@PathVariable Long railcarNum, @RequestBody Railcar railcar) {
        Railcar updatedRailcar = openService.updateRailcar(railcarNum, railcar);
        if (updatedRailcar == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRailcar);
    }

    @DeleteMapping("/railcars/{railcarNum}")
    @Operation(summary = "Delete railcar")
    public ResponseEntity<String> deleteRailcar(@PathVariable Long railcarNum) {
        if (!openService.deleteRailcar(railcarNum)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("railcar deleted");
    }

    @GetMapping("/operations")
    @Operation(summary = "Get all operations")
    public List<RailcarOperation> getAllOperations() {
        return openService.getAllOperations();
    }

    @GetMapping("/operations/{id}")
    @Operation(summary = "Get operation by id")
    public ResponseEntity<?> getOperationById(@PathVariable Long id) {
        RailcarOperation railcarOperation = openService.getOperationById(id);
        if (railcarOperation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(railcarOperation);
    }

    @GetMapping("/operations/by-railcar/{railcarNum}")
    @Operation(summary = "Get operations by railcar number")
    public List<RailcarOperation> getOperationsByRailcarNum(@PathVariable Long railcarNum) {
        return openService.getOperationsByRailcarNum(railcarNum);
    }

    @GetMapping("/operations/by-type")
    @Operation(summary = "Get operations by type")
    public List<RailcarOperation> getOperationsByType(@RequestParam String operationType) {
        return openService.getOperationsByType(operationType);
    }

    @PostMapping("/operations")
    @Operation(summary = "Insert operation")
    public RailcarOperation insertOperation(@RequestBody RailcarOperation railcarOperation) {
        return openService.insertOperation(railcarOperation);
    }

    @PutMapping("/operations/{id}")
    @Operation(summary = "Update operation")
    public ResponseEntity<?> updateOperation(@PathVariable Long id, @RequestBody RailcarOperation railcarOperation) {
        RailcarOperation updatedRailcarOperation = openService.updateOperation(id, railcarOperation);
        if (updatedRailcarOperation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRailcarOperation);
    }

    @DeleteMapping("/operations/{id}")
    @Operation(summary = "Delete operation")
    public ResponseEntity<String> deleteOperation(@PathVariable Long id) {
        if (!openService.deleteOperation(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("operation deleted");
    }
}

