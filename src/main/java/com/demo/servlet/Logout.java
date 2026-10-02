package com.demo.servlet;

import java.io.IOException;

import com.demo.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			session.invalidate();
			req.setAttribute("success-message", "Logout successful!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else {
			req.setAttribute("error-message", "Session Expired");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

}
