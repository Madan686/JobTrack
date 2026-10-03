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
		String query = "Insert into interviews (application_id,round,interview_date,mode,result,feedback)  values(?,?,?,?,?,?);";

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
	public Interview getInterviewById(Integer id) {
		String query = "Select * from interviews where interview_id=?";
		Interview interview = null;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
	public List<Interview> getInterviewsByApplication(Integer application_id) {

		List<Interview> list = new ArrayList<>();
		String query = "Select * from interviews where application_id=?";
		Interview interview = null;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, application_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				interview = new Interview();
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
	public List<Interview> getUpcomingInterviews() {
		List<Interview> list = new ArrayList<>();
		String query = "SELECT * FROM interviews WHERE interview_date >= NOW() ORDER BY interview_date;";
		Interview interview = null;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				interview = new Interview();
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
	public void updateInterview(Interview interview) {
		String query = "Update interviews set application_id=? ,round=? ,interview_date=? ,mode=? ,result=? ,feedback=?  where interview_id=?;";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, interview.getApplicationId());
			ps.setString(2, interview.getRound());
			ps.setTimestamp(3, interview.getInterviewDate());
			ps.setString(4, interview.getMode());
			ps.setString(5, interview.getResult());
			ps.setString(6, interview.getFeedback());
			ps.setInt(7, interview.getInterviewId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteInterview(Integer id) {
		String query = "Delete from interviews where interview_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
