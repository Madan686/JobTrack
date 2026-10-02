package com.demo.dao;

import com.demo.dto.Application;

public interface ApplicationDAO {

	public void applyForJob(Application application);

	public Application getApplicationById(Integer id);

	public Application getApplicationsByUser(Integer user_id);

	public Application getApplicationsByJob(Integer job_id);

	public void updateApplicationStatus(Application application);

	public void deleteApplication(Integer id);

}
