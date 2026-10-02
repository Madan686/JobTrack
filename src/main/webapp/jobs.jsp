<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Available Jobs</title>
</head>

<body>

	<h2>Available Jobs</h2>

	<form action="searchJobs" method="get">

		<input type="text" name="keyword" placeholder="Search jobs">

		<button type="submit">Search</button>

	</form>
	<br>
	<table border="1">

		<tr>
			<th>Company</th>
			<th>Job Title</th>
			<th>Location</th>
			<th>Job Type</th>
			<th>Salary</th>
			<th>Deadline</th>
			<th>Action</th>
		</tr>
		<c:forEach var="job" items="${jobs}">

			<tr>
				<td>${job.companyName}</td>

				<td>${job.jobTitle}</td>

				<td>${job.location}</td>

				<td>${job.jobType}</td>

				<td>${job.salary}</td>

				<td>${job.deadline}</td>

				<td><a href="applyJob?jobId=${job.jobId}"> Apply </a></td>

			</tr>

		</c:forEach>

	</table>

</body>

</html>

 --%>