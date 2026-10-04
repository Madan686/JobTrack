package com.demo.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import com.demo.dao.InterviewDAO;
import com.demo.dao.InterviewDAOImpl;
import com.demo.dto.Interview;
import com.demo.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addInterview")
public class AddInterview extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {

			Interview interview = new Interview();

			interview.setApplicationId(Integer.parseInt(req.getParameter("applicationId")));

			interview.setRound(req.getParameter("round"));

			interview.setInterviewDate(Timestamp.valueOf(req.getParameter("interview_date").replace("T", " ") + ":00"));

			interview.setMode(req.getParameter("mode"));
			interview.setResult(req.getParameter("result"));
			interview.setFeedback(req.getParameter("feedback"));

			InterviewDAO interviewDAO = new InterviewDAOImpl();

			interviewDAO.scheduleInterview(interview);

			resp.sendRedirect("viewInterviews.jsp");

		} else {

			req.setAttribute("error-message", "Session Expired..");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}