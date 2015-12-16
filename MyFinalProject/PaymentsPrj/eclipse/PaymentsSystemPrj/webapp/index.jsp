<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="user" class="org.it.my.paymentsprj.dal.dto.User" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page&copy;</title>
<style type="text/css">
	header {
		position: relative;
		margin-bottom: 0.2em;
		padding: 0.2em;
		border: 1px solid silver;
		border-radius: 3px;
	}
	.content {
		position: relative;
		padding: 0.2em;
		border: 1px solid silver;
	}
	.available, .is-adding {
		background-color: green;
	}
	.zero, .is-payment, .error {
		background-color: red;
	}
	.locked {
		background-color: silver;
	}
	.has-blocked-account {
		background-color: blue;
	}
</style>
</head>
<body>
	<header>
		<h1 style="margin: 0.4em; color: blue; display: inline-block;">
			PaymentsSystem&copy, Prj.
		</h1>
		<h2 style="float: right; margin: 0.4em; color: green; display: inline-block;">
			Welcome, ${userRole eq 'ADMIN' ? "admin" : "user"} <a href="#">
				${user.firstName}&nbsp;${user.lastName}
			</a>!&nbsp;<a href="logout">Exit(x)</a>
		</h2>
	</header>
	<section class="content">
		<c:choose>
			<c:when test="${userRole eq 'ADMIN'}">
				<jsp:include page="admin.jsp" />
			</c:when>
			<c:when test="${userRole eq 'CLIENT'}">
				<jsp:include page="client.jsp" />
			</c:when>
		</c:choose>
	</section>
</body>
</html>