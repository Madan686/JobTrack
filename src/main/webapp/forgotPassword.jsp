<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
</head>
<body>

	<form action="forgotPassword" method="post">
		<fieldset>

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
					<td>Enter email:</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>Enter the new password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>Confirm the new password:</td>
					<td><input type="password" name="confirm"></td>
				</tr>
				<tr>
					<td><button type="submit">Reset</button></td>
				</tr>
			</table>
		</fieldset>
	</form>

</body>
</html>