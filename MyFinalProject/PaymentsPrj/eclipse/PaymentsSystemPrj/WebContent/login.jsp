<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="org.it.my.paymentsprj.dal.entity.User" %>

<%
	User user = (User) session.getAttribute("user");

	if (user != null) {
		
		response.sendRedirect("index.jsp");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page&copy;</title>
</head>
<body>
	<h2 style="color: green;">Welcome!</h2>
	<div style="padding: 0.2em; border: 1px solid silver; border-radius: 2px; display: inline-block;">
		<form action="login" method="POST">
			<table>
				<tr>
					<td>UserID:</td>
					<td>
						<input type="text" name="id" />
					</td>
				</tr>
					<td>Password:</td>
					<td>
						<input type="password" name="passwd" />
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right;">
						<input type="submit" value="Login =>" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>