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
		String query = "insert into jobs (company_name, job_title, location, job_type, salary,description, deadline )values(?,?,?,?,?,?,?);";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, job.getCompany_name());
			ps.setString(2, job.getJob_title());
			ps.setString(3, job.getLocation());
			ps.setString(4, job.getJob_type());
			ps.setDouble(5, job.getSalary());
			ps.setString(6, job.getDescription());
			ps.setDate(7, job.getDeadline());
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
			while (rs.next()) {
				job = new Job();
				job.setJob_id(rs.getInt("job_id"));
				job.setCompany_name(rs.getString("company_name"));
				job.setDeadline(rs.getDate("deadline"));
				job.setDescription(rs.getString("description"));
				job.setJob_title(rs.getString("job_title"));
				job.setJob_type(rs.getString("job_type"));
				job.setLocation(rs.getString("location"));
				job.setSalary(rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return job;
	}

	@Override
	public List<Job> getAllJobs() {
		List<Job> list = new ArrayList<>();
		Job job = null;
		String query = "Select * from jobs";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				job = new Job();
				job.setJob_id(rs.getInt("job_id"));
				job.setCompany_name(rs.getString("company_name"));
				job.setDeadline(rs.getDate("deadline"));
				job.setDescription(rs.getString("description"));
				job.setJob_title(rs.getString("job_title"));
				job.setJob_type(rs.getString("job_type"));
				job.setLocation(rs.getString("location"));
				job.setSalary(rs.getDouble("salary"));
				list.add(job);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateJob(Job job) {
		String query = "update jobs set company_name=?, job_title=?, location=?, job_type=?, salary=?,description=?, deadline=?  where job_id=?; ";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, job.getCompany_name());
			ps.setString(2, job.getJob_title());
			ps.setString(3, job.getLocation());
			ps.setString(4, job.getJob_type());
			ps.setDouble(5, job.getSalary());
			ps.setString(6, job.getDescription());
			ps.setDate(7, job.getDeadline());
			ps.setInt(8, job.getJob_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteJob(Integer id) {
		String query = "delete from jobs where job_id=?;";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Job> searchJobs(String search) {

		List<Job> list = new ArrayList<>();

		String query = "select * from jobs where company_name like ?  or job_title liks ? or location like ? or job_type like ?";

		try {

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, "%" + search + "%");
			ps.setString(2, "%" + search + "%");
			ps.setString(3, "%" + search + "%");
			ps.setString(4, "%" + search + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Job job = new Job();

				job.setJob_id(rs.getInt("job_id"));
				job.setCompany_name(rs.getString("company_name"));
				job.setDeadline(rs.getDate("deadline"));
				job.setDescription(rs.getString("description"));
				job.setJob_title(rs.getString("job_title"));
				job.setJob_type(rs.getString("job_type"));
				job.setLocation(rs.getString("location"));
				job.setSalary(rs.getDouble("salary"));

				list.add(job);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
