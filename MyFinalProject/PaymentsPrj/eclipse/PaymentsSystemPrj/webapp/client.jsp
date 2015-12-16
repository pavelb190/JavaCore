<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="accountSelected" value="${requestScope.accountSelected}" />
	<div id="user-bank-accounts" style="border: 1px solid blue; width: 25%; display: table-cell;">
		<table>
			<caption style="color: blue; text-align: left; font-weight: bold;">User's BankAccounts:</caption>
			<thead>
				<tr>
					<th>AccNumber</th>
					<th>Balance</th>
					<th>Available</th>
					<th>Disable</th>
					<th>Proceed</th>
				</tr>
			</thead>
			<tbody style="text-align: right;">
				<c:choose>
					<c:when test="${empty requestScope.userBankAccounts}">
						
						<tr>
							<td colspan="4" style="text-align: center;">
								<h3>You have no Accounts. Sorry</h3>
							</td>
						</tr>
						
					</c:when>
					<c:otherwise>
						
						<c:forEach var="userBankAccount" items="${requestScope.userBankAccounts}">
							<c:set var="balance" value="${userBankAccount.balance}" />
							<c:set var="isAvailable" value="${userBankAccount.available}" />
							<c:set var="class_bankAccountRow" value="class=${isAvailable ? (balance > 0 ? 'available' : 'zero') : 'locked'}" />
							<tr ${class_bankAccountRow}>
								<td>${userBankAccount.id}</td>
								<td>${userBankAccount.balance}</td>
								<td>${isAvailable ? "+" : "-"}</td>
								<td>
									<c:choose>
										<c:when test="${isAvailable}">
											<a href="bank-account/disable?accnum=${userBankAccount.id}">Disable(x)</a>
										</c:when>
										<c:otherwise>
											x
										</c:otherwise>
									</c:choose>
								</td>
								<td>
									<c:choose>
										<c:when test="${isAvailable}">
											<a href="index?accnum=${userBankAccount.id}">Select &gt;&gt;</a>
										</c:when>
										<c:otherwise>
											x
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
						
					</c:otherwise>
				</c:choose>
				
			</tbody>
		</table>
	</div>
	<div style="width: 65%; display: ${accountSelected ? 'table-cell' : 'none'};">
		<div style="border: 1px solid blue; width: 35%; display: table-cell;">
			<div style="border-bottom: 1px solid silver;">
				<c:if test="${accountSelected}">
					
					Available User's CreditCards: <select>
						<option>--=CreditCards=--</option>
						<c:forEach var="accountCreditCard" items="${requestScope.accountCreditCards}">
							<option value="${accountCreditCard.id}">${accountCreditCard.id}</option>
						</c:forEach>
					</select>
					
				</c:if>
			</div>
			<form action="transaction/add" method="POST">
				<input type="hidden" name="accnum" value="${requestScope.accountNum}" />
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
					<div class="message error">
						${requestScope.error}
						<h3 style="font-size: 11px;">${requestScope.cause}</h3>
					</div>
					<div>
						<input type="reset" value="Clear" /><input type="submit" value="Apply" />
					</div>
				</div>
			</form>
		</div>
		<div style="border: 1px solid blue; width: 25%; display: table-cell;">
			<c:if test="${accountSelected}">
				
				<h3 style="color: silver; margin: 0.6em;">Transactions History:</h3>
				<table align="center">
					<thead>
						<tr>
							<th>#</th>
							<th>Money Amount</th>
							<th>Payment/Adding</th>
							<th>Committed At</th>
							<th>*</th>
						</tr>
					</thead>
					<tbody>
						
						<c:choose>
							<c:when test="${empty requestScope.accountTransactions}">
								
								<tr>
									<td colspan="5" style="text-align: center;">
										<h3 style="color: silver;">No Transactions Commited.</h3>
									</td>
								</tr>
								
							</c:when>
							<c:otherwise>
								
								<c:forEach var="transaction" items="${requestScope.accountTransactions}">
									<c:set var="class_transactionHistoryRow" value="${transaction.payment ? 'is-payment' : 'is-adding'}" />
									<tr class="${class_transactionHistoryRow}" style="text-align: right;">
										<td></td>
										<td>
											<span style="font-size: 9px;">${transaction.payment ? "+" : "-"}</span>&nbsp;${transaction.moneyAmount}
										</td>
										<td style="text-align: center;">${transaction.payment ? "-" : "+"}</td>
										<td style="text-align: center">
											<fmt:formatDate type="both" value="${transaction.committedAt}" />
										</td>
										<td style="background-color: white;">
											<a href="javascript:void(0)" style="font-size: 9px; color: silver; text-decoration: none;" title="${transaction.description}">?</a>
										</td>
									</tr>
								</c:forEach>
								
							</c:otherwise>
						</c:choose>
						
					</tbody>
				</table>
				
			</c:if>
		</div>
	</div>