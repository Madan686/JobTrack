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

@WebServlet("/register")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO userDAO = new UserDAOImpl();
		User user = new User();

		if (req.getParameter("password").equals(req.getParameter("confirm"))) {
			user.setEmail(req.getParameter("email"));
			user.setName(req.getParameter("name"));
			user.setPhone(req.getParameter("phone"));
			user.setPassword(req.getParameter("password"));
			userDAO.registerUser(user);
			req.setAttribute("success-message", "Account created successfullt.....");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else {
			req.setAttribute("error-message", "Password miss-match");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
	}
}
