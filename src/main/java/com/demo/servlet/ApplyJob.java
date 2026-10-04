package com.demo.servlet;

import java.io.IOException;
import com.demo.dao.JobDAO;
import com.demo.dao.JobDAOImpl;
import com.demo.dto.Job;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/applyJob")
public class ApplyJob extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JobDAO jobDAO = new JobDAOImpl();
		Job job = jobDAO.getJobById(Integer.parseInt(req.getParameter("jobId")));
		if (job != null) {
			req.setAttribute("job", job);
			RequestDispatcher rd = req.getRequestDispatcher("application.jsp");
			rd.forward(req, resp);
		} else {
			resp.sendRedirect("jobs.jsp");
		}
	}
}