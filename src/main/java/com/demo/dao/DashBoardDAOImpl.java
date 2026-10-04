package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.dto.Application;
import com.demo.dto.Interview;
import com.demo.util.Connectivity;

public class DashBoardDAOImpl implements DashboardDAO {

	private Connection con;

	public DashBoardDAOImpl() {
		this.con = Connectivity.getConnection();
	}

	@Override
	public Integer getTotalApplications(Integer userId) {
		Integer count = 0;
		String query = "select count(application_id) as TotalCount from applications where user_id=?;";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt("TotalCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public List<Interview> getUpcomingInterviews(Integer userId) {
		List<Interview> list = new ArrayList<>();
		String query = "select * from interviews i1 join applications a1 on i1.application_id=a1.application_id join users u1 on a1.user_id=u1.user_id where u1.user_id=? and interview_date >= now();";
		Interview interview = null;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				interview = new Interview();
				interview.setInterviewId(rs.getInt("i1.interview_id"));
				interview.setApplicationId(rs.getInt("i1.application_id"));
				interview.setFeedback(rs.getString("i1.feedback"));
				interview.setInterviewDate(rs.getTimestamp("i1.interview_date"));
				interview.setMode(rs.getString("i1.mode"));
				interview.setResult(rs.getString("i1.result"));
				interview.setRound(rs.getString("i1.round"));
				list.add(interview);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Map<String, Integer> getApplicationStatusSummary(Integer userId) {

		Map<String, Integer> map = new HashMap<>();

		String query = "Select count(application_id) as statusCount, status from applications where user_id=? group by status ;";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				map.put(rs.getString("status"), rs.getInt("statusCount"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<Application> getRecentApplications(Integer userId) {

		List<Application> list = new ArrayList<>();
		String query = "select * from applications where user_id=? and datediff(appliedDate,curDate())<=2;";
		Application application = null;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				application = new Application();
				application.setApplicationId(rs.getInt("application_id"));
				application.setUserId(rs.getInt("user_id"));
				application.setJobId(rs.getInt("job_id"));
				application.setAppliedDate(rs.getDate("appliedDate"));
				application.setStatus(rs.getString("status"));
				application.setNotes(rs.getString("notes"));
				list.add(application);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
