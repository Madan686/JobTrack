package com.demo.servlet;

import java.io.IOException;
import java.sql.Date;

import com.demo.dao.ApplicationDAO;
import com.demo.dao.ApplicationDAOImpl;
import com.demo.dto.Application;
import com.demo.dto.User;

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
		User user = (User) session.getAttribute("user");

		if (user != null) {

			Application application = new Application();

			application.setUserId(user.getUserId());
			application.setJobId(Integer.parseInt(req.getParameter("jobId")));
			application.setAppliedDate(new Date(System.currentTimeMillis()));
			application.setStatus("Applied");
			application.setNotes(req.getParameter("notes"));

			ApplicationDAO applicationDAO = new ApplicationDAOImpl();

			applicationDAO.applyForJob(application);

			resp.sendRedirect("viewApplications.jsp");

		} else {

			req.setAttribute("error-message", "Session Expired..");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}