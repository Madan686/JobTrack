package com.demo.servlet;

import java.io.IOException;

import com.demo.dao.ApplicationDAO;
import com.demo.dao.ApplicationDAOImpl;
import com.demo.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteApplications")
public class DeleteApplications extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ApplicationDAO applicationDAO = new ApplicationDAOImpl();
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			applicationDAO.deleteApplication(Integer.parseInt(req.getParameter("id")), user.getUserId());
			session.setAttribute("success-message", "Application deleted successfully");
			resp.sendRedirect("applications.jsp");
		} else {
			req.setAttribute("error-message", "Session Expired..");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}