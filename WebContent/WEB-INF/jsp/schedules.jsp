<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule</title>
</head>
<body background="C:\Users\Administrator\Downloads\g.jpg">
<h1 align="center">Schedule Details</h1>
<form:form>
<center>
<table border="1">
 
<tr>
<th>Schedule ID</th>
<th>Ship ID</th>
<th>Route ID</th>
<th>Start Date</th>
<th colspan="2">Action</th>
</tr>
<tr>
<td>${d.scheduleID}</td>
<td>${d.shipID}</td>
<td>${d.routeID}</td>
<td>${ date}</td>
<td><a href="modiContr?id=${d.scheduleID}">Edit</a></td>
<td><a href="delete?id=${d.scheduleID}">Delete</a></td>	
</tr>

</table>
<br>
<a href="admin">Go Home</a>
</center>
</form:form>
</body>
</html>