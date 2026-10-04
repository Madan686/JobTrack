package com.demo.servlet;

import java.io.IOException;

import com.demo.dao.UserDAO;
import com.demo.dao.UserDAOImpl;
import com.demo.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateAccount extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO userDAO = new UserDAOImpl();
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			user.setName(req.getParameter("name"));
			user.setEmail(req.getParameter("email"));
			user.setPhone(req.getParameter("phone"));
			userDAO.updateUser(user);
			req.setAttribute("success-message", "Account updated successful");
			req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
		} else {
			req.setAttribute("error-message", "Session expired...");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

}
