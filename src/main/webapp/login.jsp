<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
	<form action="login" method="POST">
		<fieldset>
			<legend>User Login</legend>
			<table >
				<tr>
					<td>Enter Email:</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>Enter Password:</td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td><button type="submit">Login</button></td>
				</tr>
				<tr>
					<td><a href="register.jsp">New User? Register</a></td>
					<td><a href="forgotPassword.jsp">Forgot Password?</a></td>
				</tr>
			</table>

		</fieldset>
	</form>

</body>
</html>