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

@WebServlet("/forgotPassword")
public class ForgotPassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.getUserByEmail(req.getParameter("email"));

		if (user != null) {
			if (req.getParameter("password").equals(req.getParameter("confirm"))) {
				user.setPassword(req.getParameter("password"));
				userDAO.updateUser(user);
				req.setAttribute("success-message", "Password updated successfully....");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			} else {
				req.setAttribute("error-message", "password missmatch");
				req.getRequestDispatcher("forgotPassword.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("error-message", "Account dont exist...");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
