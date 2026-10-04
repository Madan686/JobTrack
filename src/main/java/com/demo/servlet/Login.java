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

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.getUserByEmail(req.getParameter("email"));
		if (user != null) {

			if (req.getParameter("password").equals(user.getPassword())) {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				req.setAttribute("success-message", "Login successful...");
				req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
			} else {
				req.setAttribute("error-message", "password incorrect!.....");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("error-message", "User Not Found");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

}
