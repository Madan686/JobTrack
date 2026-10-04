package com.demo.servlet;

import java.io.IOException;

import com.demo.dao.JobDAO;
import com.demo.dao.JobDAOImpl;
import com.demo.dto.Job;
import com.demo.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addJobs")
public class AddJobs extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		JobDAO jobDAO = new JobDAOImpl();

		Job job = new Job();

		HttpSession session = req.getSession();

		User user = (User) session.getAttribute("user");

		if (user != null) {

			Integer userId = user.getUserId();

			job.setUser_id(userId);

			job.setCompany_name(req.getParameter("company_name"));
			job.setJob_title(req.getParameter("job_title"));
			job.setLocation(req.getParameter("location"));
			job.setJob_type(req.getParameter("job_type"));
			job.setSalary(req.getParameter("salary"));
			job.setDescription(req.getParameter("description"));

			String deadline = req.getParameter("deadline");

			if (deadline != null && !deadline.isEmpty()) {
				job.setDeadline(java.sql.Date.valueOf(deadline));
			}

			jobDAO.addJob(job);

			session.setAttribute("success-message", "Job added successfully");

			resp.sendRedirect("jobs.jsp");

		} else {

			req.setAttribute("error-message", "Session Expired..");

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}