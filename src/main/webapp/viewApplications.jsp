<%@ page import="com.demo.dto.User"%>
<%@ page import="com.demo.dto.Application"%>
<%@ page import="java.util.List"%>
<%@ page import="com.demo.dao.ApplicationDAOImpl"%>
<%@ page import="com.demo.dao.ApplicationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Applications</title>
</head>
<body>
	<h1>Applications Info</h1>
	<a href="dashboard.jsp">Back</a>
	<br>
	<br>
	<table border="1">
		<thead>
			<tr>
				<th>Application Id</th>
				<th>Job Id</th>
				<th>Notes</th>
				<th>Applied Date</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			HttpSession ses = request.getSession();
			User user = (User) ses.getAttribute("user");
			ApplicationDAO applicationDAO = new ApplicationDAOImpl();
			List<Application> applicationList = applicationDAO.getApplicationsByUser(user.getUserId());
			for (Application app : applicationList) {
			%>
			<tr>
				<td><%=app.getApplicationId()%></td>
				<td><%=app.getJobId()%></td>
				<td><%=app.getNotes()%></td>
				<td><%=app.getAppliedDate()%></td>
				<td><%=app.getStatus()%></td>
				<td>
					<form action="deleteApplications" method="post">
						<input type="hidden" name="id"
							value="<%=app.getApplicationId()%>">
						<button type="submit">Delete</button>
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