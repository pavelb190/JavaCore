<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="user-list-all" style="width: 31%; display: inline-block;">
	<table>
		<thead>
			<tr>
				<th>#</th>
				<th>UserId</th>
				<th>Acc.Blocked N</th>
				<th>Proceed</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach var="userDetails" items="${usersDetailsAll}">
				
				<c:set var="accountBlockedCnt" value="${userDetails.accountBlockedCount}" />
				
				<tr class="${accountBlockedCnt > 0 ? 'has-blocked-account' : 'locked'}">
					<td></td>
					<td style="text-align: right;">${userDetails.id}</td>
					<td style="text-align: right;">${accountBlockedCnt > 0 ? accountBlockedCnt : '-'}</td>
					<td>
						<a href="index?userid=${userDetails.id}">Select &gt;&gt;</a>
					</td>
				</tr>
				
			</c:forEach>
			
		</tbody>
	</table>
</div>

	<c:if test="${userSelected}">
		
		<div id="user-details" style="width: 67%; display: inline-block;">
			<h2 style="display: inline-block;">
				User: <a href="javascript:void(0)" style="display: inline-block;">
					${userDetails.firstName}&nbsp;${userDetails.lastName}
				</a>
			</h2>
			<h2 style="font-size: 21px; color: silver; padding-left: 0.6em; display: inline-block;" title="Available Account's Count">
				(${userDetails.accountAvailableCount})
			</h2>
			<h3 style="margin-top: 0.2em; margin-bottom: 0.9em; color: silver;">
				email: ${userDetails.email}
			</h3>
			User's Accounts All:
			<table>
				<thead>
					<tr>
						<th>#</th>
						<th>AccNum</th>
						<th>Balance</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="userBankAccount" items="${userBankAccounts}">
						
						<tr class="${userBankAccount.available ? (userBankAccount.balance > 0 ? 'available' : 'zero') : 'locked'}">
							<td></td>
							<td>${userBankAccount.id}</td>
							<td style="text-align: right;">${userBankAccount.balance}</td>
							<td style="text-align: center;">${userBankAccount.available ? (userBankAccount.balance > 0 ? '+' : '-') : '[...]'}</td>
							<td style="text-align: center;">
								<c:choose>
									<c:when test="${!userBankAccount.available}">
										<a href="bank-account/enable?userid=${userDetails.id}&accnum=${userBankAccount.id}">Unlock...</a>
									</c:when>
									<c:otherwise>
										-
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						
					</c:forEach>
					
				</tbody>
			</table>
		</div>
		
	</c:if>