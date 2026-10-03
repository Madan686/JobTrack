package com.demo.dao;

import java.util.List;

import com.demo.dto.Application;

public interface ApplicationDAO {

	public void applyForJob(Application application);

	public Application getApplicationById(Integer id);

	public List<Application> getApplicationsByUser(Integer user_id);

	public List<Application> getApplicationsByJob(Integer job_id);

	public void updateApplicationStatus(Application application);

	public void deleteApplication(Integer id);

}
