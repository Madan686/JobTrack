<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.demo.dao.InterviewDAO"%>
<%@page import="com.demo.dao.InterviewDAOImpl"%>
<%@page import="com.demo.dto.Interview"%>
<%@page import="com.demo.dto.User"%>

<%
User user = (User) session.getAttribute("user");

if (user == null) {

	request.setAttribute("error-message", "Session Expired..");
	request.getRequestDispatcher("login.jsp").forward(request, response);
	return;
}

InterviewDAO interviewDAO = new InterviewDAOImpl();

List<Interview> interviewList = interviewDAO.getUpcomingInterviews(user.getUserId());
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>View Interviews</title>

</head>

<body>

	<h2>My Interviews</h2>

	<a href="dashboard.jsp">Dashboard</a>
	<a href="addJobs.jsp">Add Job</a>
	<a href="jobs.jsp">View Jobs</a>
	<a href="viewApplications.jsp">View Applications</a>
	<a href="updateAccount.jsp">Update Account</a>
	<a href="logout">Logout</a>

	<hr>

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
		for (Interview interview : interviewList) {
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