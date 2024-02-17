<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="<c:url value="/resources/style.css"/>"rel="stylesheet">
</head>
<body>
<jsp:include page="home.jsp" />
<br><br><br>
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