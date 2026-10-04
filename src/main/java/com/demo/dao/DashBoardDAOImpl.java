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

		String query = "SELECT COUNT(application_id) AS totalCount  FROM applications  WHERE user_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				count = rs.getInt("totalCount");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public List<Interview> getUpcomingInterviews(Integer userId) {

		List<Interview> list = new ArrayList<>();

		String query = "SELECT i1.* FROM interviews i1 JOIN applications a1 ON i1.application_id = a1.application_id WHERE a1.user_id=? AND i1.interview_date >= NOW() ORDER BY i1.interview_date";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Interview interview = new Interview();

				interview.setInterviewId(rs.getInt("interview_id"));
				interview.setApplicationId(rs.getInt("application_id"));
				interview.setFeedback(rs.getString("feedback"));
				interview.setInterviewDate(rs.getTimestamp("interview_date"));
				interview.setMode(rs.getString("mode"));
				interview.setResult(rs.getString("result"));
				interview.setRound(rs.getString("round"));

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

		String query = "SELECT COUNT(application_id) AS statusCount, status FROM applications WHERE user_id=? GROUP BY status";

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

		String query = "SELECT * FROM applications WHERE user_id=? AND applied_date >= DATE_SUB(CURDATE(), INTERVAL 2 DAY) ORDER BY applied_date DESC";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Application application = new Application();

				application.setApplicationId(rs.getInt("application_id"));
				application.setUserId(rs.getInt("user_id"));
				application.setJobId(rs.getInt("job_id"));
				application.setAppliedDate(rs.getDate("applied_date"));
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