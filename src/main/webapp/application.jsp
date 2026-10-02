```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Apply for Job</title>
</head>

<body>
	<h2>Apply for Job</h2>
	<form action="addApplication" method="post">
		<fieldset>
			<table>
				<tr>
					<td>Company Name:</td>
					<td>${job.companyName}</td>
				</tr>
				<tr>
					<td>Job Title:</td>
					<td>${job.jobTitle}</td>
				</tr>
				<tr>
					<td>Location:</td>
					<td>${job.location}</td>
				</tr>
				<tr>
					<td>Applied Date:</td>
					<td>${job.deadline}</td>
				</tr>
				<tr>
					<td>Notes:</td>
					<td><textarea name="notes"></textarea></td>
				</tr>
				<tr>
					<td>
						<button type="submit">Apply for Job</button>
					</td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>