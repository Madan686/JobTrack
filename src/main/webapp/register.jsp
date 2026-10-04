<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>
	<form action="register" method="POST">
		<fieldset>
			<legend>User Registration</legend>
			<%
			String errorMessage = (String) request.getAttribute("error-message");
			%>
			<%
			if (errorMessage != null) {
			%>
			<p style="color: red;"><%=errorMessage%></p>
			<%
			}
			%>
			<table>
				<tr>
					<td>Enter the Name:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Enter the Email:</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>Enter the Phone No:</td>
					<td><input type="tel" name="phone"></td>
				</tr>
				<tr>
					<td>Enter the Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>Confirm the password:</td>
					<td><input type="password" name="confirm"></td>
				</tr>
				<tr>
					<td><button>Register</button></td>
				</tr>
				<tr>
					<td><a href="login.jsp">Have account? Login...</a>
				</tr>
			</table>
		</fieldset>
	</form>

</body>
</html>