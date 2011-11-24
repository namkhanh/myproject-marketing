<%@ page errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/include/include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head><title> TrangChu</title></head>
  <body>
  	<h3>View Users</h3>
  	<hr/>
    <table style="width: 700px;">
    	<c:forEach items="${listUser}" var="user" >
			<tr>
	    		<td style="width: 100px">${user.accountName}</td>
	    		<td style="width: 250px">${user.name}</td>
	    		<td style="width: 250px">${user.email}</td>
	    		<td ><a href="editUser.html?id=${user.id}">Edit</a></td>
	    		<td ><a href="javascript:doDelete(${user.id});">Delete</a></td>
	    	</tr>
   	 	</c:forEach>
    </table>
  </body>
  <script src="<c:url value='scripts/users.js'/>" type="text/javascript"></script>
</html>