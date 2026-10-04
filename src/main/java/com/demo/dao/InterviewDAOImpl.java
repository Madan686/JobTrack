package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.dto.Interview;
import com.demo.util.Connectivity;

public class InterviewDAOImpl implements InterviewDAO {

	private Connection con;

	public InterviewDAOImpl() {
		this.con = Connectivity.getConnection();
	}

	@Override
	public void scheduleInterview(Interview interview) {

		String query = "INSERT INTO interviews (application_id, round, interview_date, mode, result, feedback) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, interview.getApplicationId());
			ps.setString(2, interview.getRound());
			ps.setTimestamp(3, interview.getInterviewDate());
			ps.setString(4, interview.getMode());
			ps.setString(5, interview.getResult());
			ps.setString(6, interview.getFeedback());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Interview getInterviewById(Integer interview_id, Integer user_id) {

		String query = "SELECT i.* FROM interviews i JOIN applications a ON i.application_id = a.application_id  WHERE i.interview_id = ? AND a.user_id = ?";

		Interview interview = null;

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, interview_id);
			ps.setInt(2, user_id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				interview = new Interview();

				interview.setInterviewId(rs.getInt("interview_id"));
				interview.setApplicationId(rs.getInt("application_id"));
				interview.setRound(rs.getString("round"));
				interview.setInterviewDate(rs.getTimestamp("interview_date"));
				interview.setMode(rs.getString("mode"));
				interview.setResult(rs.getString("result"));
				interview.setFeedback(rs.getString("feedback"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return interview;
	}

	@Override
	public List<Interview> getInterviewsByApplication(Integer application_id, Integer user_id) {

		List<Interview> list = new ArrayList<>();

		String query = "SELECT i.* FROM interviews i JOIN applications a ON i.application_id = a.application_id WHERE i.application_id = ? AND a.user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, application_id);
			ps.setInt(2, user_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Interview interview = new Interview();

				interview.setInterviewId(rs.getInt("interview_id"));
				interview.setApplicationId(rs.getInt("application_id"));
				interview.setRound(rs.getString("round"));
				interview.setInterviewDate(rs.getTimestamp("interview_date"));
				interview.setMode(rs.getString("mode"));
				interview.setResult(rs.getString("result"));
				interview.setFeedback(rs.getString("feedback"));

				list.add(interview);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Interview> getUpcomingInterviews(Integer user_id) {

		List<Interview> list = new ArrayList<>();

		String query = "SELECT i.* FROM interviews i  JOIN applications a ON i.application_id = a.application_id  WHERE a.user_id = ? AND i.interview_date >= NOW() ORDER BY i.interview_date";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, user_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Interview interview = new Interview();

				interview.setInterviewId(rs.getInt("interview_id"));
				interview.setApplicationId(rs.getInt("application_id"));
				interview.setRound(rs.getString("round"));
				interview.setInterviewDate(rs.getTimestamp("interview_date"));
				interview.setMode(rs.getString("mode"));
				interview.setResult(rs.getString("result"));
				interview.setFeedback(rs.getString("feedback"));

				list.add(interview);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void updateInterview(Interview interview, Integer user_id) {

		String query = "UPDATE interviews i JOIN applications a ON i.application_id = a.application_id SET i.application_id=?, i.round=?, i.interview_date=?, i.mode=?, i.result=?, i.feedback=? WHERE i.interview_id=? AND a.user_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, interview.getApplicationId());
			ps.setString(2, interview.getRound());
			ps.setTimestamp(3, interview.getInterviewDate());
			ps.setString(4, interview.getMode());
			ps.setString(5, interview.getResult());
			ps.setString(6, interview.getFeedback());
			ps.setInt(7, interview.getInterviewId());
			ps.setInt(8, user_id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteInterview(Integer interview_id, Integer user_id) {

		String query = "DELETE i FROM interviews i JOIN applications a  ON i.application_id = a.application_id WHERE i.interview_id = ? AND a.user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, interview_id);
			ps.setInt(2, user_id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}