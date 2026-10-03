package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.dto.Application;
import com.demo.util.Connectivity;

import java.util.ArrayList;

import java.util.List;

public class ApplicationDAOImpl implements ApplicationDAO {

	private Connection con;

	public ApplicationDAOImpl() {
		this.con = Connectivity.getConnection();
	}

	@Override
	public void applyForJob(Application application) {
		String query = "INSERT INTO APPLICATIONS (user_id, job_id, applied_date, status, notes) VALUES (?, ?, ?, ?, ?);";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, application.getUserId());
			ps.setInt(2, application.getJobId());
			ps.setDate(3, application.getAppliedDate());
			ps.setString(4, application.getStatus());
			ps.setString(5, application.getNotes());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Application getApplicationById(Integer id) {
		String query = "Select * from applications where application_id=?";
		Application application = null;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				application = new Application();
				application.setApplicationId(rs.getInt("application_id"));
				application.setJobId(rs.getInt("job_id"));
				application.setUserId(rs.getInt("user_id"));
				application.setAppliedDate(rs.getDate("applied_date"));
				application.setNotes(rs.getString("notes"));
				application.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return application;
	}

	@Override
	public List<Application> getApplicationsByUser(Integer user_id) {
		String query = "Select * from applications where user_id=?";
		List<Application> list = new ArrayList<>();
		Application application = null;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				application = new Application();
				application.setApplicationId(rs.getInt("application_id"));
				application.setJobId(rs.getInt("job_id"));
				application.setUserId(rs.getInt("user_id"));
				application.setAppliedDate(rs.getDate("applied_date"));
				application.setNotes(rs.getString("notes"));
				application.setStatus(rs.getString("status"));
				list.add(application);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<Application> getApplicationsByJob(Integer job_id) {
		String query = "Select * from applications where job_id=?";
		List<Application> list = new ArrayList<>();
		Application application = null;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, job_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				application = new Application();
				application.setApplicationId(rs.getInt("application_id"));
				application.setJobId(rs.getInt("job_id"));
				application.setUserId(rs.getInt("user_id"));
				application.setAppliedDate(rs.getDate("applied_date"));
				application.setNotes(rs.getString("notes"));
				application.setStatus(rs.getString("status"));
				list.add(application);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public void updateApplicationStatus(Application application) {
		String query = "update applications set user_id=?, job_id=?, applied_date=?, status=?, notes=? where application_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, application.getJobId());
			ps.setInt(2, application.getUserId());
			ps.setDate(3, application.getAppliedDate());
			ps.setString(4, application.getStatus());
			ps.setString(5, application.getNotes());
			ps.setInt(6, application.getApplicationId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteApplication(Integer id) {
		String query = "Delete from applications where application_id=?;";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
