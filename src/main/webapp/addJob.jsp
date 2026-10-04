<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Job</title>
</head>

<body>

	<h2>Add Job</h2>

	<a href="dashboard.jsp">Dashboard</a>
	<a href="jobs.jsp">View Jobs</a>
	<a href="viewApplications.jsp">View Applications</a>
	<a href="updateAccount.jsp">Update Account</a>
	<a href="logout">Logout</a>

	<hr>

	<form action="addJobs" method="post">

		<table>

			<tr>
				<td>Company Name</td>
				<td><input type="text" name="company_name" required></td>
			</tr>

			<tr>
				<td>Job Title</td>
				<td><input type="text" name="job_title" required></td>
			</tr>

			<tr>
				<td>Location</td>
				<td><input type="text" name="location"></td>
			</tr>

			<tr>
				<td>Job Type</td>
				<td><input type="text" name="job_type"></td>
			</tr>

			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary"></td>
			</tr>

			<tr>
				<td>Description</td>
				<td><textarea name="description" rows="5" cols="30"></textarea>
				</td>
			</tr>

			<tr>
				<td>Deadline</td>
				<td><input type="date" name="deadline"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Add Job"></td>
			</tr>

		</table>

	</form>

</body>
</html>