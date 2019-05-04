package com.cg.traineeManagement.service;

import java.util.ArrayList;

import com.cg.traineeManagement.model.TraineeDetails;

public interface TMSService {
	int login(TraineeDetails traineeDetails);
	int addTrainee(TraineeDetails traineeDetails);
    int updateTrainee(TraineeDetails traineeDetails);
	int deleteTrainee(int id);
	ArrayList<TraineeDetails> getAll();
	TraineeDetails getById(int id);
}
