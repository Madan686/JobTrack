<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="java.util.List"%>
<%@page import="com.demo.dao.ApplicationDAO"%>
<%@page import="com.demo.dao.ApplicationDAOImpl"%>
<%@page import="com.demo.dto.Application"%>
<%@page import="com.demo.dto.User"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Applications</title>
</head>

<body>

	<h2>My Applications</h2>

	<a href="dashboard.jsp">Dashboard</a>
	<a href="addJobs.jsp">Add Job</a>
	<a href="jobs.jsp">View Jobs</a>
	<a href="updateAccount.jsp">Update Account</a>
	<a href="logout">Logout</a>

	<hr>

	<%
	User user = (User) session.getAttribute("user");

	if (user == null) {
		request.setAttribute("error-message", "Session Expired..");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		return;
	}

	ApplicationDAO applicationDAO = new ApplicationDAOImpl();

	List<Application> applicationList = applicationDAO.getApplicationsByUser(user.getUserId());
	%>

	<table border="1">

		<tr>
			<th>Application ID</th>
			<th>Job ID</th>
			<th>Applied Date</th>
			<th>Status</th>
			<th>Notes</th>
			<th>Action</th>
		</tr>

		<%
		for (Application app : applicationList) {
		%>

		<tr>

			<td><%=app.getApplicationId()%></td>

			<td><%=app.getJobId()%></td>

			<td><%=app.getAppliedDate()%></td>

			<td><%=app.getStatus()%></td>

			<td><%=app.getNotes()%></td>

			<td>

				<form action="scheduleInterview" method="get">

					<input type="hidden" name="applicationId"
						value="<%=app.getApplicationId()%>"> <input type="submit"
						value="Schedule Interview">

				</form>
			</td>
			<td>

				<form action="deleteApplications" method="post">

					<input type="hidden" name="id" value="<%=app.getApplicationId()%>">

					<input type="submit" value="Delete">

				</form>

			</td>

		</tr>

		<%
		}
		%>

	</table>

</body>
</html>