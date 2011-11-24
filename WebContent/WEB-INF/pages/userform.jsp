<%@ page errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/include/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>User</title>
</head>
<body>
	<form:form id="userForm" action="editUser.html" commandName="user">
	<form:hidden path="id"/>
		<h3>Add / Edit User</h3>
		<hr/>
		<table style="width: 500px;">
			<tr>
				<td style="width: 100px">Account</td>
				<td style="width: 400px"><form:input path="accountName" /></td>
			</tr>
			<tr>
				<td style="width: 100px">Pass</td>
				<td style="width: 400px"><form:password path="password" /></td>
			</tr>
			<tr>
				<td style="width: 100px">Name</td>
				<td style="width: 400px"><form:input path="name" /></td>
			</tr>
			<tr>
				<td style="width: 100px">Email</td>
				<td style="width: 400px"><form:input path="email" /></td>
			</tr>
		</table>
		<hr/>
		<button type="submit">Save / Update</button>
	</form:form>
</body>
</html>