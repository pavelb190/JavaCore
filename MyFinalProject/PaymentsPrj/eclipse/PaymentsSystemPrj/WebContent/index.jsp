<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="org.it.my.paymentsprj.dal.entity.User" %>
<%@ page import="org.it.my.paymentsprj.dal.entity.BankAccount" %>
<%@ page import="org.it.my.paymentsprj.domain.service.BankAccountService" %>

<%
	User user = (User) session.getAttribute("user");

	if (user == null) {
		
		response.sendRedirect("login.jsp");
		
	} else {
%>

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
	.available {
		background-color: green;
	}
	.zero {
		background-color: red;
	}
	.locked {
		background-color: silver;
	}
</style>
</head>
<body>
	<header>
		<h1 style="margin: 0.4em; color: blue; display: inline-block;">
			PaymentsSystem&copy, Ltd.
		</h1>
		<h2 style="float: right; margin: 0.4em; color: green; display: inline-block;">
			Welcome, user <a href="#"><%= user.getFirstName() + " " + user.getLastName() %></a>!&nbsp;<a href="logout">Exit(x)</a>
		</h2>
	</header>
	<section class="content">
		<div id="user-bank-accounts" style="border: 1px solid blue; width: 25%; display: table-cell;">
			<%
				BankAccountService bankAccountService = new BankAccountService();
				
				List<BankAccount> userBankAccounts = bankAccountService.getUserBankAccounts(user);
			%>
			<table>
				<caption style="color: blue; text-align: left; font-weight: bold;">User's BankAccounts:</caption>
				<thead>
					<tr>
						<th>AccNumber</th>
						<th>Balance</th>
						<th>Available</th>
						<th>Proceed</th>
						<th>Disable</th>
					</tr>
				</thead>
				<tbody style="text-align: right;">
					<%
						for(BankAccount userBankAccount : userBankAccounts) {
							
							%>
								
								<tr <%= 
									
									userBankAccount.isAvailable() ? (userBankAccount.getBalance() > 0 ? "class='available'" : "class='zero'") : "class='locked'"
								
								%> >
									<td><%= userBankAccount.getId() %></td>
									<td><%= userBankAccount.getBalance() %></td>
									<td><%= userBankAccount.isAvailable() ? "+" : "-" %></td>
									<td>
										<a href="index.jsp?accnum=<%= userBankAccount.getId() %>"><%= userBankAccount.isAvailable() ? "Select >>" : "x" %></a>
									</td>
									<td>
										<a href="bank-account/disable?accnum=<%= userBankAccount.getId() %>"><%= userBankAccount.isAvailable() ? "Disable" : "x" %></a>
									</td>
								</tr>
								
							<%
						}
					%>
				</tbody>
			</table>
		</div>
		<div style="border: 1px solid blue; width: 35%; display: table-cell;">
			<div style="border-bottom: 1px solid silver;">Available User's CreditCards: <select><option>--=CreditCards=--</option></select></div>
			<form action="payment" method="POST">
				<div>
					Choose the type of operation:
					<div style="padding-left: 2.9em; padding-top: 0.2em;">
						<input type="radio" name="operation-type" value="is-payment" />Payment<br/>
						<input type="radio" name="operation-type" value="is-add-funds" />Adding
					</div>
					<div>
						Money amount: <input type="text" name="money-amount" />
					</div>
					<div>
						Description: <textarea name="description"></textarea>
					</div>
					<div>
						<input type="reset" value="Clear" /><input type="submit" value="Apply" />
					</div>
				</div>
			</form>
		</div>
		<div style="border: 1px solid blue; width: 25%; display: table-cell;">
			Transactions History:
		</div>
	</section>
	<%
		//out.println("User e-mail: " + user.getEmail());
	%>
</body>
</html>

<% } %>