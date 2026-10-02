package com.demo.dao;

import java.sql.Connection;

import com.demo.dto.Application;
import com.demo.util.Connectivity;

public class ApplicationDAOImpl implements ApplicationDAO {

	private Connection con;

	public ApplicationDAOImpl() {
		this.con = Connectivity.getConnection();
	}

	@Override
	public void applyForJob(Application application) {
		String query = "Insert into applications values(0,?)";

	}

	@Override
	public Application getApplicationById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application getApplicationsByUser(Integer user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application getApplicationsByJob(Integer job_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateApplicationStatus(Application application) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteApplication(Integer id) {
		// TODO Auto-generated method stub

	}

}
