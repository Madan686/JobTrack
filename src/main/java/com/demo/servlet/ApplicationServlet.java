package com.demo.servlet;

import java.io.IOException;
import java.sql.Date;

import com.demo.dao.ApplicationDAO;
import com.demo.dao.ApplicationDAOImpl;
import com.demo.dto.Application;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addApplication")
public class ApplicationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		Integer userId = (Integer) session.getAttribute("userId");

		Integer jobId = Integer.parseInt(req.getParameter("jobId"));

		String notes = req.getParameter("notes");

		Application application = new Application();

		application.setUserId(userId);
		application.setJobId(jobId);
		application.setAppliedDate(new Date(System.currentTimeMillis()));
		application.setStatus("Applied");
		application.setNotes(notes);

		ApplicationDAO applicationDAO = new ApplicationDAOImpl();

		applicationDAO.applyForJob(application);

		resp.sendRedirect("applications.jsp");
	}
}
