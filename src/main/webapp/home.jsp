<%@page import="virinchi.model.UserTable"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
<jsp:include page="navbar.jsp" />

<h1>This is Home Page. Welcome :  ${username} </h1>
<hr>
<%List<UserTable> userList= (List<UserTable>)request.getAttribute("userData"); %>
<table border="2px" width="100%">
<tr>
<td> Id </td>
<td> Username </td>
<td> Password </td>
</tr>

<% for(UserTable ut :userList){ %>
<tr>
<td><%=ut.getId() %></td>
<td><%=ut.getUsername() %></td>
<td><%=ut.getPassword() %></td>
</tr>
<%} %>


</table>

</body>
</html>