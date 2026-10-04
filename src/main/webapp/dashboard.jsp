<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.demo.dao.DashBoardDAOImpl"%>
<%@page import="com.demo.dto.Application"%>
<%@page import="com.demo.dto.Interview"%>
<%@page import="com.demo.dto.User"%>



<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Dashboard</title>

</head>

<body>

	<h2>JobTrack Dashboard</h2>

	<%
	User user = (User) session.getAttribute("user");

	if (user == null) {

		request.setAttribute("error-message", "Session Expired..");

		request.getRequestDispatcher("login.jsp").forward(request, response);

		return;
	}

	DashBoardDAOImpl dashboardDAO = new DashBoardDAOImpl();

	Integer totalApplications = dashboardDAO.getTotalApplications(user.getUserId());

	Map<String, Integer> statusSummary = dashboardDAO.getApplicationStatusSummary(user.getUserId());

	List<Application> recentApplications = dashboardDAO.getRecentApplications(user.getUserId());

	List<Interview> upcomingInterviews = dashboardDAO.getUpcomingInterviews(user.getUserId());
	%>

	<p>
		Welcome,
		<%=user.getName()%></p>
	<hr>

	<table>
		<tr>
			<td><a href="addJob.jsp">Add Job</a></td>
			<td><a href="jobs.jsp">View Jobs</a></td>
			<td><a href="viewApplications.jsp">View Applications</a></td>
			<td><a href="viewInterviews.jsp">View Interviews</a></td>
			<td><a href="updateAccount.jsp">Update Account</a></td>
			<td><a href="logout">Logout</a></td>
		</tr>
	</table>
	<hr>

	<%
	String message = (String) request.getAttribute("success-message");
	if (message != null) {
	%>
	<%=message%>
	<%
	}
	%>
	<h3>Application Overview</h3>


	<table border="1">
		<tr>
			<th>Total Applications</th>
			<%
			for (Map.Entry<String, Integer> entry : statusSummary.entrySet()) {
			%>
			<th><%=entry.getKey()%></th>
			<%
			}
			%>
		</tr>
		<tr>
			<td><%=totalApplications%></td>
			<%
			for (Map.Entry<String, Integer> entry : statusSummary.entrySet()) {
			%>
			<td><%=entry.getValue()%></td>
			<%
			}
			%>
		</tr>
	</table>
	<hr>
	<h3>Recent Applications</h3>
	<table border="1">
		<tr>
			<th>Application ID</th>
			<th>Job ID</th>
			<th>Applied Date</th>
			<th>Status</th>
			<th>Notes</th>
		</tr>
		<%
		for (Application app : recentApplications) {
		%>
		<tr>
			<td><%=app.getApplicationId()%></td>
			<td><%=app.getJobId()%></td>
			<td><%=app.getAppliedDate()%></td>
			<td><%=app.getStatus()%></td>
			<td><%=app.getNotes()%></td>
		</tr>
		<%
		}
		%>
	</table>

	<hr>

	<h3>Upcoming Interviews</h3>

	<table border="1">
		<tr>
			<th>Interview ID</th>
			<th>Application ID</th>
			<th>Round</th>
			<th>Interview Date</th>
			<th>Mode</th>
			<th>Result</th>
			<th>Feedback</th>
		</tr>
		<%
		for (Interview interview : upcomingInterviews) {
		%>
		<tr>

			<td><%=interview.getInterviewId()%></td>
			<td><%=interview.getApplicationId()%></td>
			<td><%=interview.getRound()%></td>
			<td><%=interview.getInterviewDate()%></td>
			<td><%=interview.getMode()%></td>
			<td><%=interview.getResult()%></td>
			<td><%=interview.getFeedback()%></td>
		</tr>
		<%
		}
		%>
	</table>

</body>

</html>