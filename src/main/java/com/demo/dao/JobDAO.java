package com.demo.dao;

import java.util.List;

import com.demo.dto.Job;

public interface JobDAO {

	public void addJob(Job job);

	public Job getJobById(Integer id);

	public List<Job> getAllJobs();

	public void updateJob(Job job);

	public void deleteJob(Integer id);

	public List<Job> searchJobs(String search);

}
