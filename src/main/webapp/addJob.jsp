<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Jobs</title>
</head>
<body>
	<form action="addJobs" method="post">
		<fieldset>
			<table>
				<tr>
					<td>Enter the Company name:</td>
					<td><input type="text" name="company_name"></td>
				</tr>
				<tr>
					<td>Enter the job title:</td>
					<td><input type="text" name="job_title"></td>
				</tr>
				<tr>
					<td>Enter the location:</td>
					<td><input type="text" name="location"></td>
				</tr>
				<tr>
					<td>Enter the job type:</td>
					<td><input type="text" name="job_type"></td>
				</tr>
				<tr>
					<td>Enter the salary:</td>
					<td><input type="number" name="salary" step="0.01"></td>
				</tr>
				<tr>
					<td>Enter the description:</td>
					<td><textarea name="description"></textarea></td>
				</tr>
				<tr>
					<td>Enter the deadline</td>
					<td><input type="date" name="deadline"></td>
				</tr>
				<tr>
					<td><button>Add job</button></td>
				</tr>
			</table>

		</fieldset>
	</form>
</body>
</html>