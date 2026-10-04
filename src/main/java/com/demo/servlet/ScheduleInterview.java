package com.demo.servlet;

import java.io.IOException;

import com.demo.dao.ApplicationDAO;
import com.demo.dao.ApplicationDAOImpl;
import com.demo.dto.Application;
import com.demo.dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/scheduleInterview")
public class ScheduleInterview extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {

			ApplicationDAO applicationDAO = new ApplicationDAOImpl();

			Application application = applicationDAO
					.getApplicationById(Integer.parseInt(req.getParameter("applicationId")), user.getUserId());

			if (application != null) {

				req.setAttribute("application", application);

				RequestDispatcher rd = req.getRequestDispatcher("interview.jsp");

				rd.forward(req, resp);

			} else {

				req.setAttribute("error-message", "Application Not Found");

				RequestDispatcher rd = req.getRequestDispatcher("viewApplications.jsp");

				rd.forward(req, resp);
			}

		} else {

			req.setAttribute("error-message", "Session Expired..");

			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");

			rd.forward(req, resp);
		}
	}
}