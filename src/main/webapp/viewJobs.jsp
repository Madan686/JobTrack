<%@ page import="com.demo.dto.Job"%>
<%@ page import="java.util.List"%>
<%@ page import="com.demo.dao.JobDAOImpl"%>
<%@ page import="com.demo.dao.JobDAO"%>
<%@ page import="com.demo.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Jobs</title>
</head>
<body>
	<h1>Jobs Info</h1>
	<a href="dashboard.jsp">Back</a>
	<table border="1">
		<thead>
			<tr>
				<td>Company name</td>
				<td>Description</td>
				<td>Job title</td>
				<td>Job type</td>
				<td>Location</td>
				<td>Salary</td>
				<td>Deadline</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<%
			HttpSession ses = request.getSession();
			User user = (User) ses.getAttribute("user");
			JobDAO jobDAO = new JobDAOImpl();
			List<Job> jobList = jobDAO.getJobsByUser(user.getUserId());
			%>
			<%
			for (Job job : jobList) {
			%>
			<tr>
				<td><%=job.getCompany_name()%></td>
				<td><%=job.getDescription()%></td>
				<td><%=job.getJob_title()%></td>
				<td><%=job.getJob_type()%></td>
				<td><%=job.getLocation()%></td>
				<td><%=job.getSalary()%></td>
				<td><%=job.getDeadline()%></td>
				<td>
					<form action="addApplication" method="post">
						<input type="hidden" name="jobId" value="<%=job.getJob_id()%>">
						<input type="text" name="notes" placeholder="Notes">
						<button type="submit">Apply</button>
					</form>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>