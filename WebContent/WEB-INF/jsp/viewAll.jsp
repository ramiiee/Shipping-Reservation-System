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
<h1><center>Ship Management System</center></h1>
<h2><center>Ships Available</center></h2>
<body background="C:\Users\Administrator\Downloads\g.jpg">
<form:form>
<table align="center" border="1">
<tr>
<th>Ship ID </th>
<th>Ship Name</th>
<th>Seating Capacity </th>
<th>Reservation Capacity</th>
<th colspan="2">Actions</th>
</tr>

<c:forEach items="${c}" var="s">
<tr>
<td>${s.shipID}</td>
<td>${s.shipName}</td>
<td>${s.seatingCapacity}</td>
<td>${s.reservationCapacity}</td>
<td><a href="editcontr?id=${s.shipID}">Edit</a></td>
<td><a href="delete_ship?id=${s.shipID}">Delete</a></td>
</tr>
</c:forEach>

</table>
</form:form>
<form:form method="POST"  action="/ShippingReservationSystem/confirm" >
<center><input type="submit" value="confirm"></center>
</form:form>
<br>
<center> <a href="admin">Go Home</a></center>

</body>
</html>