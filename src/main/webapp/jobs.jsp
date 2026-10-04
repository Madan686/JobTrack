<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="java.util.List"%>
<%@page import="com.demo.dao.JobDAO"%>
<%@page import="com.demo.dao.JobDAOImpl"%>
<%@page import="com.demo.dto.Job"%>
<%@page import="com.demo.dto.User"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jobs</title>
</head>

<body>

	<h2>My Jobs</h2>

	<a href="dashboard.jsp">Dashboard</a>
	<a href="addJobs.jsp">Add Job</a>
	<a href="viewApplications.jsp">View Applications</a>
	<a href="updateAccount.jsp">Update Account</a>
	<a href="logout">Logout</a>

	<hr>

	<h3>Search Jobs</h3>

	<form action="searchJobs" method="get">

		<%
		User user = (User) session.getAttribute("user");

		if (user == null) {
			request.setAttribute("error-message", "Session Expired..");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		JobDAO jobDAO = new JobDAOImpl();
		List<Job> jobList = jobDAO.getJobsByUser(user.getUserId());
		%>

		<table>

			<tr>
				<td><input type="text" name="keyword"
					placeholder="Search company, job title, location"></td>

				<td><input type="submit" value="Search"></td>
			</tr>

		</table>

	</form>

	<hr>

	<table border="1">

		<tr>
			<th>Job ID</th>
			<th>Company</th>
			<th>Job Title</th>
			<th>Location</th>
			<th>Job Type</th>
			<th>Salary</th>
			<th>Deadline</th>
			<th>Action</th>
		</tr>

		<%
		for (Job job : jobList) {
		%>

		<tr>

			<td><%=job.getJob_id()%></td>
			<td><%=job.getCompany_name()%></td>
			<td><%=job.getJob_title()%></td>
			<td><%=job.getLocation()%></td>
			<td><%=job.getJob_type()%></td>
			<td><%=job.getSalary()%></td>
			<td><%=job.getDeadline()%></td>

			<td><a href="applyJob?jobId=<%=job.getJob_id()%>"> Apply </a></td>

		</tr>

		<%
		}
		%>

	</table>

</body>
</html>