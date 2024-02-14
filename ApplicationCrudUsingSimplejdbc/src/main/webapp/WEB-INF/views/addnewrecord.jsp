
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/jsfile/Validate.js" />"></script>
</head>
<body>
	<jsp:include page="home.jsp"></jsp:include>
	<div class='sonu'>
		<h1>Register Here</h1>
		<form name='frm' action='save' method='POST'>
			<div>
				<input type='text' name='name' value='' id='n'
					placeholder=' Enter Name' onkeyup="validateName()" /><br>
				<br> <span id='p'></span>
			</div>
			<div>
				<input type='text' name='email' value='' placeholder='Enter Email' /><br>
				<br>
			</div>
			<div>
				<input type='text' name='contact' value='' id='c'
					placeholder='Enter Contact' onkeyup="validateContact()" /><br>
				<br> <span id='s'></span>
			</div>
			<div>
				<input type='submit' name='s' value='Add New Record' /><br>
				<br>
			</div>
		</form>
	</div>
	${msg}
</body>
</html>