<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page session="true" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ship Details</title>
</head>
<h2><center>Schedules Available</center></h2>
<body background="C:\Users\Administrator\Downloads\blue-water-ocean-sea-wallpaper.jpg">
<form:form>
<table align="center" border="1">
<tr>
<th>Schedule ID </th>
<th>Route ID</th>
<th>Ship ID</th>
<th>Start Date</th>
<th colspan="2">Actions</th>
</tr>

<c:forEach items="${i}" var="s">
<tr>
<td>${s.scheduleID}</td>
<td>${s.routeID}</td>
<td>${s.shipID}</td>
<td>${s.startDate}</td>
<td><a href="modiContr?id=${s.scheduleID}">Edit</a></td>
<td><a href="delete_schedule?id=${s.scheduleID}">Delete</a></td>
</tr>
</c:forEach>

</table>
<br>
<center> <a href="admin">Go Home</a></center>
</form:form>
<br>
<form:form method="POST"  action="/ShippingReservationSystem/confirm2" >
<center><input type="submit" value="confirm"></center>
</form:form>
</body>
</html>