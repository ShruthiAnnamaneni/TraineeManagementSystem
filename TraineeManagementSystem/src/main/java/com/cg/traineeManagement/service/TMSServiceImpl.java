package com.cg.traineeManagement.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.traineeManagement.dao.TMSDao;
import com.cg.traineeManagement.model.TraineeDetails;

@Component("tService")
@Service
@Transactional
public class TMSServiceImpl implements TMSService{
	@Autowired
	TMSDao tDao;
	
	@Override
	public int login(TraineeDetails traineeDetails) {
		// TODO Auto-generated method stub
		return tDao.login(traineeDetails);
	}
	@Override
	public int addTrainee(TraineeDetails traineeDetails) {
		// TODO Auto-generated method stub
		return tDao.addTrainee(traineeDetails);
	}

	@Override
	public int updateTrainee(TraineeDetails traineeDetails) {
		// TODO Auto-generated method stub
		return tDao.updateTrainee(traineeDetails);
	}

	@Override
	public int deleteTrainee(int id) {
		// TODO Auto-generated method stub
		return tDao.deleteTrainee(id);
	}

	@Override
	public ArrayList<TraineeDetails> getAll() {
		// TODO Auto-generated method stub
		return tDao.getAll();
	}

	@Override
	public TraineeDetails getById(int id) {
		// TODO Auto-generated method stub
		return tDao.getById(id);
	}
	
}
