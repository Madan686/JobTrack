package com.demo.dao;

import java.util.List;

import com.demo.dto.Interview;

public interface InterviewDAO {

	void scheduleInterview(Interview interview);

	Interview getInterviewById(Integer interview_id, Integer user_id);

	List<Interview> getInterviewsByApplication(Integer application_id, Integer user_id);

	List<Interview> getUpcomingInterviews(Integer user_id);

	void updateInterview(Interview interview);

	void deleteInterview(Integer interview_id, Integer user_id);
}