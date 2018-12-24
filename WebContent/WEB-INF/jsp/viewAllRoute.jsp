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
<body background="C:\Users\Administrator\Downloads\blue-water-ocean-sea-wallpaper.jpg">
<h1 align="center">Routes Details</h1>
<form:form>
<table align="center" border="1">
<tr>
<th>Route ID </th>
<th>Source</th>
<th>Destination </th>
<th>Travel Duration</th>
<th>Fare</th>
<th colspan="2">Actions</th>
</tr>

<c:forEach items="${c}" var="s">
<tr>
<td>${s.routeID}</td>
<td>${s.source}</td>
<td>${s.destination}</td>
<td>${s.travelDuration}</td>
<td>${s.fare}</td>
<td><a href="editrcontr?id=${s.routeID}">Edit</a></td>
<td><a href="delete_route?id=${s.routeID}">Delete</a></td>
</tr>
</c:forEach>

</table>
<br>
<center> <a href="admin">Go Home</a></center>
</form:form>

<br>
<form:form method="POST"  action="/ShippingReservationSystem/confirm1" >
<center><input type="submit" value="confirm"></center>
</form:form>
</body>
</html>