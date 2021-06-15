<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1 align="center">Love Calculator</h1>
	<form:form action="process-page-dto-modelAttribute" method="get" modelAttribute="userInfo">
		<div align="center">
			<p>
				<lable for="yourName">Your Name: </lable>
				<form:input type="text" id="yourName" path="yourName" />
			</p>
			<p>
				<lable for="crushName">Crush Name: </lable>
				<form:input type="text" id="crushName" path="crushName" />
			</p>
			<input type="submit" value="Calculate" />
		</div>
	</form:form>
</body>
</html>