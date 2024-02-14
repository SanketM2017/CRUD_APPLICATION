<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/style.css"/>"rel="stylesheet">
</head>
<body>
<jsp:include page="home.jsp"></jsp:include>
<div class='search11'>
<form  action='searchrecord'>
<input type='text' name='name' value=''/><br><br>
<input type='submit'  />
<br><br><br>
</form>
</div>
<center>
<table border=2px; width=50%; height=auto; border-collapse=collapse;>
<tr>
<th>Name</th>
<th>Email</th>
<th>Contact</th>
<th>Delete</th>
<th>Update</th></tr>


<c:forEach var="ss" items="${regrecord}">
<tr>
<td>${ss.getName() }</td>
<td>${ss.getEmail() }</td>
<td>${ss.getContact() }</td>
<td><a href='del?userid=${ss.getId()}'>Delete</a></td>
<td><a href='upda?userid=${ss.getId()}&name=${ss.getName()}&email=${ss.getEmail()}&contact=${ss.getContact()}'>Update</a></td>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>