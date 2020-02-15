<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="emp" class="com.example.svc.model.Employee" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
</head>
<body>
	<table>
		<tr>
			<td>Id: </td>
			<td><jsp:getProperty property="id" name="emp"/>
		</tr>
		<tr>
			<td>Salutation: </td>
			<td><jsp:getProperty property="salutation" name="emp"/>
		</tr>
		<tr>
			<td>First Name: </td>
			<td><jsp:getProperty property="firstName" name="emp"/>
		</tr>
		<tr>
			<td>Last Name: </td>
			<td><jsp:getProperty property="lastName" name="emp"/>
		</tr>
		<tr>
			<td>Job Id: </td>
			<td><jsp:getProperty property="jobId" name="emp"/>
		</tr>
		<tr>
			<td>Location Id: </td>
			<td><jsp:getProperty property="jobLocationId" name="emp"/>
		</tr>
		<tr>
			<td>Status: </td>
			<td><jsp:getProperty property="active" name="emp"/>
		</tr>
	</table>
<br>
<a href="${pageContext.request.contextPath}/index.html">Home</a>
</body>
</html>