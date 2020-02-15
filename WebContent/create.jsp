<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="emp" class="com.example.svc.model.Employee"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/create_emp">
	<input type="hidden" name="id" id="id"/>
	<table>
		<tr>
			<td>Salutation: </td>
			<td>
				<select name="salutation" id="salutation">
					<option value="Mr.">Mr.</option>
					<option value="Miss">Miss</option>
					<option value="Mrs.">Mrs.</option>
				</select> 
			</td>
		</tr>
		<tr>
			<td>First Name: </td>
			<td><input type="text" id="firstName" name="first_name"></td>
		</tr>
		<tr>
			<td>Last Name: </td>
			<td><input type="text" id="lastName" name="last_name"></td>
		</tr>
		<tr>
			<td>Job Id: </td>
			<td>
				<select name="job_id" id="job_id">
					<option value="1001">Developer</option>
					<option value="1002">Specialist</option>
					<option value="1003">Architect</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Job Location Id: </td>
			<td>
				<select name="job_loc_id" id="job_loc_id">
					<option value="1001">Fremont</option>
					<option value="1002">Sanjose</option>
					<option value="1003">Santa Clara</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				<select name="status" id="status">
					<option value="true">Active</option>
					<option value="false">Inactive</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><input type="submit" name="create"/></td>
			<td><input type="reset"/></td>
		</tr>
	</table>	
	</form>
</body>
</html>