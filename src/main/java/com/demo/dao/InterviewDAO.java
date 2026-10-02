package com.demo.dao;

import java.util.List;

import com.demo.dto.Interview;

public interface InterviewDAO {

	public void scheduleInterview(Interview interview);

	public Interview getInterviewById(Integer id);

	public Interview getInterviewsByApplication(Integer application_id);

	public List<Interview> getUpcomingInterviews();

	public void updateInterview(Interview interview);

	public void deleteInterview(Integer id);
}
