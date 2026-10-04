<%@page import="com.demo.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
</head>
<body>

	<%
	User user = (User) session.getAttribute("user");
	%>
	<%
	if (user != null) {
	%>
	<header>
		<h1>
			Welcome
			<%=user.getName()%>
		</h1>
		<nav>
			<ul>

				<li><a href="viewApplications.jsp">View Applications</a></li>
				<li><a href="updateAccount.jsp">Update Account</a></li>
				<li><a href="forgotPassword.jsp">Reset Password</a></li>
				<li><a href="addJob.jsp">Add Jobs</a></li>
				<li><button>
						<a href="logout">Logout</a>
					</button></li>
			</ul>
		</nav>
		<%
		String successMessage = (String) request.getAttribute("success-message");
		%>

		<%
		if (successMessage != null) {
		%>
		<p style="color: green;"><%=successMessage%></p>
		<%
		}
		%>

		<table border="1">
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Phone</td>
					<td>Email</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=user.getUserId()%></td>
					<td><%=user.getName()%></td>
					<td><%=user.getPhone()%></td>
					<td><%=user.getEmail()%></td>
				</tr>
			</tbody>
		</table>
	</header>
	<%
	} else {
	request.setAttribute("error-message", "Session expired login again");
	request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	%>

</body>
</html>