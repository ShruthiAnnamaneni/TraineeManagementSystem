package com.cg.traineeManagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.traineeManagement.model.TraineeDetails;
import com.cg.traineeManagement.service.TMSService;

@RestController
public class TMSController {
	@Autowired
	TMSService tService;
	@GetMapping("/")
	public String sayHi() {
		return "Hello";
	}
	@GetMapping("/login")
	public ResponseEntity login(@RequestBody TraineeDetails traineeDetails) {
		tService.login(traineeDetails);
		return new ResponseEntity(HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity insertData(@RequestBody TraineeDetails traineeDetails) {
		tService.addTrainee(traineeDetails);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity updateData(@RequestBody TraineeDetails traineeDetails) {
		tService.updateTrainee(traineeDetails);
		return new ResponseEntity(HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity deleteData(@RequestBody int id) {
		tService.deleteTrainee(id);
		return new ResponseEntity(HttpStatus.OK);
		
	}
	@GetMapping("/getById")
	public TraineeDetails getById(@RequestBody int id) {
		TraineeDetails traineee=tService.getById(id);
			return traineee;
	}

	@GetMapping("/getAll")
	public ArrayList<TraineeDetails> getAllProducts(){
		ArrayList<TraineeDetails> tDetails = tService.getAll();
		return tDetails;
	}
}
