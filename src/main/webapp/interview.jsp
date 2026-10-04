<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.demo.dto.Application"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Schedule Interview</title>

</head>

<body>

	<h2>Schedule Interview</h2>

	<a href="dashboard.jsp">Dashboard</a>
	<a href="jobs.jsp">View Jobs</a>
	<a href="viewApplications.jsp">View Applications</a>
	<a href="updateAccount.jsp">Update Account</a>
	<a href="logout">Logout</a>

	<hr>

	<h3>Application Details</h3>

	<%
	Application app = (Application) request.getAttribute("application");

	if (app == null) {
		response.sendRedirect("viewApplications.jsp");
		return;
	}
	%>

	<table border="1">

		<tr>
			<th>Application ID</th>
			<td><%=app.getApplicationId()%></td>
		</tr>

		<tr>
			<th>Job ID</th>
			<td><%=app.getJobId()%></td>
		</tr>

		<tr>
			<th>Applied Date</th>
			<td><%=app.getAppliedDate()%></td>
		</tr>

		<tr>
			<th>Status</th>
			<td><%=app.getStatus()%></td>
		</tr>

	</table>

	<hr>

	<h3>Interview Details</h3>

	<form action="addInterview" method="post">

		<table>

			<tr>
				<td>Round</td>
				<td><input type="text" name="round" required></td>
			</tr>

			<tr>
				<td>Interview Date</td>
				<td><input type="datetime-local" name="interview_date" required>
				</td>
			</tr>

			<tr>
				<td>Mode</td>
				<td><select name="mode">

						<option value="Online">Online</option>
						<option value="Offline">Offline</option>
						<option value="Hybrid">Hybrid</option>

				</select></td>
			</tr>

			<tr>
				<td>Result</td>
				<td><select name="result">

						<option value="Pending">Pending</option>
						<option value="Passed">Passed</option>
						<option value="Failed">Failed</option>

				</select></td>
			</tr>

			<tr>
				<td>Feedback</td>
				<td><textarea name="feedback" rows="5" cols="30"></textarea></td>
			</tr>

			<tr>

				<td></td>

				<td><input type="hidden" name="applicationId"
					value="<%=app.getApplicationId()%>"> <input type="submit"
					value="Schedule Interview"></td>

			</tr>

		</table>

	</form>

</body>

</html>