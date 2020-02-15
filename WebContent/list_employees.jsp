<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.example.svc.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Our Employees</title>
</head>
<body>
<table>
	<tbody>
		<% List<Employee> empList = (List<Employee>) request.getAttribute("empList");
			for (int i=0;i<empList.size();i++) {
				if (i == 0) {
					out.println("<tr>");
					out.println("<td>Id</td>");
					out.println("<td>Salutation</td>");
					out.println("<td>First Name</td>");
					out.println("<td>Last Name</td>");
					out.println("<td>Job Id</td>");
					out.println("<td>Location Id</td>");
					out.println("<td>Status</td>");
				    out.println("</tr>");
				}
				Employee emp = empList.get(i);
				out.println("<tr>");
				out.println("<td>");
				out.println(emp.getId());
				out.println("<td>");
				out.println("<td>");
				out.println(emp.getSalutation());
				out.println("<td>");
				out.println("<td>");
				out.println(emp.getFirstName());
				out.println("<td>");
				out.println("<td>");
				out.println(emp.getLastName());
				out.println("<td>");
				out.println("<td>");
				out.println(emp.getJobId());
				out.println("<td>");
				out.println("<td>");
				out.println(emp.getJobLocationId());
				out.println("<td>");
				out.println("<td>");
				out.println(emp.getActive());
				out.println("<td>");
				out.println("</tr>");				
			}
		%>
	</tbody>
</table>
<br>
<a href="${pageContext.request.contextPath}/index.html">Home</a>
</body>
</html>