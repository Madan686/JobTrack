package com.demo.dao;

import java.util.List;

import com.demo.dto.Job;

public interface JobDAO {

	void addJob(Job job);

	Job getJobById(Integer id);

	List<Job> getJobsByUser(Integer user_id);

	void updateJob(Job job);

	void deleteJob(Integer job_id, Integer user_id);

	List<Job> searchJobs(Integer user_id, String search);
}
