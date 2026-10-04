package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.dto.Job;
import com.demo.util.Connectivity;

public class JobDAOImpl implements JobDAO {

	private Connection con;

	public JobDAOImpl() {
		this.con = Connectivity.getConnection();
	}

	@Override
	public void addJob(Job job) {
		String query = "insert into jobs (user_id,company_name, job_title, location, job_type, salary,description, deadline )values(?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, job.getUser_id());
			ps.setString(2, job.getCompany_name());
			ps.setString(3, job.getJob_title());
			ps.setString(4, job.getLocation());
			ps.setString(5, job.getJob_type());
			ps.setString(6, job.getSalary());
			ps.setString(7, job.getDescription());
			ps.setDate(8, job.getDeadline());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Job getJobById(Integer id) {

		Job job = null;
		String query = "Select * from jobs where job_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				job = new Job();
				job.setJob_id(rs.getInt("job_id"));
				job.setUser_id(rs.getInt("user_id"));
				job.setCompany_name(rs.getString("company_name"));
				job.setDeadline(rs.getDate("deadline"));
				job.setDescription(rs.getString("description"));
				job.setJob_title(rs.getString("job_title"));
				job.setJob_type(rs.getString("job_type"));
				job.setLocation(rs.getString("location"));
				job.setSalary(rs.getString("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return job;
	}

	@Override
	public void updateJob(Job job) {
		String query = "update jobs set company_name=?, job_title=?, location=?, job_type=?, salary=?,description=?, deadline=?  WHERE job_id=? AND user_id=?; ";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, job.getCompany_name());
			ps.setString(2, job.getJob_title());
			ps.setString(3, job.getLocation());
			ps.setString(4, job.getJob_type());
			ps.setString(5, job.getSalary());
			ps.setString(6, job.getDescription());
			ps.setDate(7, job.getDeadline());
			ps.setInt(8, job.getJob_id());
			ps.setInt(9, job.getUser_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteJob(Integer job_id, Integer user_id) {
		String query = "delete from jobs where job_id=? AND user_id=?;";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, job_id);
			ps.setInt(2, user_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Job> searchJobs(Integer user_id, String search) {

		List<Job> list = new ArrayList<>();

		String query = "SELECT * FROM jobs WHERE user_id = ? AND ( company_name LIKE ?   OR job_title LIKE ?  OR location LIKE ? OR job_type LIKE ?);";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, user_id);
			ps.setString(2, "%" + search + "%");
			ps.setString(3, "%" + search + "%");
			ps.setString(4, "%" + search + "%");
			ps.setString(5, "%" + search + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Job job = new Job();

				job.setJob_id(rs.getInt("job_id"));
				job.setUser_id(rs.getInt("user_id"));
				job.setCompany_name(rs.getString("company_name"));
				job.setDeadline(rs.getDate("deadline"));
				job.setDescription(rs.getString("description"));
				job.setJob_title(rs.getString("job_title"));
				job.setJob_type(rs.getString("job_type"));
				job.setLocation(rs.getString("location"));
				job.setSalary(rs.getString("salary"));

				list.add(job);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Job> getJobsByUser(Integer user_id) {
		List<Job> list = new ArrayList<>();
		Job job = null;
		String query = "Select * from jobs where user_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				job = new Job();
				job.setJob_id(rs.getInt("job_id"));
				job.setUser_id(rs.getInt("user_id"));
				job.setCompany_name(rs.getString("company_name"));
				job.setDeadline(rs.getDate("deadline"));
				job.setDescription(rs.getString("description"));
				job.setJob_title(rs.getString("job_title"));
				job.setJob_type(rs.getString("job_type"));
				job.setLocation(rs.getString("location"));
				job.setSalary(rs.getString("salary"));
				list.add(job);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;

	}

}
