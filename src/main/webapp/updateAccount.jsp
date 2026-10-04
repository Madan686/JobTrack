<%@page import="com.demo.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Account</title>
</head>
<body>

	<%
	User user = (User) session.getAttribute("user");
	%>
	<%
	if (user != null) {
	%>
	<form action="update" method="post">
		<fieldset>
			<legend>Update Account</legend>

			<%
			String message = (String) request.getAttribute("success-message");
			if (message != null) {
			%>
			<%=message%>
			<%
			}
			%>

			<table>
				<tr>
					<td>Enter the name:</td>
					<td><input type="text" name="name" value="<%=user.getName()%>"></td>
				</tr>
				<tr>
					<td>Enter email:</td>
					<td><input type="text" name="email"
						value="<%=user.getEmail()%>"></td>
				</tr>
				<tr>
					<td>Enter phone Number:</td>
					<td><input type="tel" name="phone"
						value="<%=user.getPhone()%>"></td>
				</tr>
				<tr>
					<td><input type="hidden" name="id"
						value="<%=user.getUserId()%>"></td>
					<td><button>Submit</button></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<%
	} else {
	request.setAttribute("error-message", "Session expired");
	request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	%>

</body>
</html>