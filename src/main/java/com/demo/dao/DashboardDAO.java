package com.demo.dao;

import java.util.List;
import java.util.Map;

import com.demo.dto.Application;
import com.demo.dto.Interview;

public interface DashboardDAO {

	Integer getTotalApplications(Integer userId);

	List<Interview> getUpcomingInterviews(Integer userId);

	Map<String, Integer> getApplicationStatusSummary(Integer userId);

	List<Application> getRecentApplications(Integer userId);
}