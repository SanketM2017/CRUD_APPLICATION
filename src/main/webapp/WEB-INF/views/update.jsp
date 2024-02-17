<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="<c:url value="/resources/style.css"/>"rel="stylesheet">
 <script src="<c:url value="/resources/jsfile/Validate.js" />"></script>
</head>
<body>
<jsp:include page="home.jsp"/>
<div class='rnt'>
<form name='frm' action='fupdate' method='POST'>
<input type='hidden' name='id' value='${i}' placeholder=''><br><br>
<div>
<input type='text' name='name' value='${name }' id='n' placeholder='Enter Name'  onkeyup="validateName()"/><br><br>
<span id='p'></span>
</div>
<div>
<input type='text' name='email' value='${email}'placeholder='Enter email' ><br><br>
</div>
<div>
<input type='text' name='contact' value='${contact}' id='c' placeholder='Enter contact' onkeyup="validateContact()"/><br><br>
<span id='s'></span>
</div>
<input type='submit' value='Update Record' />
</form>
</div>
</body>
</html>