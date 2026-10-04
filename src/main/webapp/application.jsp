<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.demo.dto.Job"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apply for Job</title>
</head>

<body>

	<h2>Apply for Job</h2>

	<a href="dashboard.jsp">Dashboard</a>
	<a href="jobs.jsp">View Jobs</a>
	<a href="viewApplications.jsp">View Applications</a>
	<a href="logout">Logout</a>

	<hr>

	<h3>Job Details</h3>

	<%
	Job job = (Job) request.getAttribute("job");

	if (job == null) {
		response.sendRedirect("jobs.jsp");
		return;
	}
	%>


	<table border="1">

		<tr>
			<th>Company</th>
			<td><%=job.getCompany_name()%></td>
		</tr>

		<tr>
			<th>Job Title</th>
			<td><%=job.getJob_title()%></td>
		</tr>

		<tr>
			<th>Location</th>
			<td><%=job.getLocation()%></td>
		</tr>

		<tr>
			<th>Job Type</th>
			<td><%=job.getJob_type()%></td>
		</tr>

		<tr>
			<th>Salary</th>
			<td><%=job.getSalary()%></td>
		</tr>

		<tr>
			<th>Description</th>
			<td><%=job.getDescription()%></td>
		</tr>

		<tr>
			<th>Deadline</th>
			<td><%=job.getDeadline()%></td>
		</tr>

	</table>

	<hr>

	<h3>Application Details</h3>

	<form action="addApplication" method="post">

		<table>

			<tr>
				<td>Notes</td>
				<td><textarea name="notes" rows="5" cols="30"></textarea></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="hidden" name="jobId"
					value="<%=job.getJob_id()%>"> <input type="submit"
					value="Apply"></td>
			</tr>

		</table>

	</form>

</body>