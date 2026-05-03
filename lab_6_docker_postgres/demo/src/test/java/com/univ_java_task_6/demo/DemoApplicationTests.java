package com.univ_java_task_6.demo;

import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.univ_java_task_6.demo.mapper.RailcarMapper;
import com.univ_java_task_6.demo.model.Railcar;
import com.univ_java_task_6.demo.model.RailcarOperation;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private RailcarMapper railcarMapper;

	// Очищаем схемы

	@Test
	public void findByRailcarNumTest() {
		Long railcarNum = 500101L; // Example railcar number
		System.out.println("Testing findByRailcarNum with num " + railcarNum);
		Railcar railcar = railcarMapper.findByRailcarNum(railcarNum);
		System.out.println("Found railcars: " + railcar + "\n");
	}

	@Test
	public void insertRailcar() {
		Railcar railcar = new Railcar(500114L, "passanger", 0.0, "government");
		System.out.println("Testing insertRailcar with num " + railcar.getRailcar_num());
		railcarMapper.insertRailcar(railcar);
		System.out.println("Result: " + railcarMapper.findAllRailcars() + "\n");
	}

	@Test
	public void deleteByRailcarNum() {
		Long railcar_num = 500103L;
		System.out.println("Testing deleteByRailcarNum with num " + railcar_num);
		railcarMapper.deleteByRailcarNum(railcar_num);
		System.out.println("Result: " + railcarMapper.findAllRailcars() + "\n");
	}

	@Test
	public void updateRailcar() {
		Long railcarNum = 500103L;
		System.out.println("Testing updateRailcar with num " + railcarNum);
		Railcar railcar = railcarMapper.findByRailcarNum(railcarNum);
		String newOwner = "roga i copita";
		railcarMapper.updateRailcar(
			railcar.getRailcar_num(), 
			railcar.getRailcar_type(),
			railcar.getRailcar_capacity_tons(),
			newOwner
		);
		System.out.println("Result: " + railcarMapper.findByRailcarNum(railcarNum) + "\n");
	}

	@Test
	public void findOperationsByRailcarNum() {
		Long railcarNum = 500101L;
		System.out.println("Testing findOperationsByRailcarNum with num " + railcarNum);
		List<RailcarOperation> railcarOperations = railcarMapper.findOperationsByRailcarNum(railcarNum);
		System.out.println("Restult: " + railcarOperations + "\n");
	}

	@Test
	public void findOperationsByOperationType() {
		String operationType = "transfer";
		System.out.println("Testing findOperationsByOperationType with type " + operationType);
		List<RailcarOperation> railcarOperations = railcarMapper.findOperationsByOperationType(operationType);
		System.out.println("Result: " + railcarOperations);
		System.out.println("All oeprations: " + railcarMapper.findAllOperations() + "\n");
	}

	@Test
	public void insertRailcarOperation() {
		RailcarOperation railcarOperation = new RailcarOperation(500114L, "transfer", "in process");
		System.out.println("Testing insertRailcarOperation with num " + railcarOperation.getRailcar_num());
		railcarMapper.insertRailcarOperation(railcarOperation);
		System.out.println("Result: " + railcarMapper.findAllOperations() + "\n");
	}

	@Test
	public void deleteRailcarOperationById() {
		Long railcarOperationId = 5L;
		System.out.println("Testing deleteRailcarOperationById with id " + railcarOperationId);
		railcarMapper.deleteRailcarOperationById(railcarOperationId);
		System.out.println("Result: " + railcarMapper.findAllOperations() + "\n");
	}

	@Test
	public void updateRailcarOperation() {
		Long railcarOpertaionId = 1L;
		RailcarOperation railcarOperation = railcarMapper.findOperationById(railcarOpertaionId);
		System.out.println("Testing updateRailcarOperation with id " + railcarOpertaionId);
		String operationStatus = "done";
		railcarMapper.updateRailcarOperation(
			railcarOperation.getId(), 
			railcarOperation.getOperation_type(), 
			operationStatus, 
			railcarOperation.getStation_from(), 
			railcarOperation.getStation_to());
		System.out.println("Result: " + railcarMapper.findOperationById(railcarOpertaionId) + "\n");
	}

	
}
