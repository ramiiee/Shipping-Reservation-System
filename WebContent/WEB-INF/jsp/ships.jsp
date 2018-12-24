<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ships</title>
</head>
<body bgcolor=#33CCCC>
<h1 align="center">Available Ships</h1>
<form:form>
<center>
<table bgcolor=#ABE3E3 border="1">

<tr><td>
<table border="1">
<tr>
<tr bgcolor=#0099FF>
<th>Route ID</th>
<th>Ship ID</th>
<th>Start Date</th>
</tr>
<c:forEach items="${j}" var="i"> 
<tr>
<td>${i.routeID}</td> 
<td>${i.shipID}</td>
<td>${i.startDate}</td>
</tr>
</c:forEach></table>
</td><td>
<table border="1">
<tr bgcolor=#0099FF>
<th>Fare</th>
<th>Travel Duration</th>
</tr>
<c:forEach items="${k}" var="i1">
<tr>
<td>${i1.fare}</td>
<td>${i1.travelDuration}</td>
</tr>
</c:forEach>
</table></td>
<td><table border="1">
<tr bgcolor=#0099FF>
<th colspan="2">Seats Available</th>
</tr>
<c:forEach items="${l}" var="i2">
<tr>
<td>${i2.reservationCapacity}</td>
</tr>
</c:forEach>
</table></td>
<td>
<table border="1">
<tr bgcolor=#0099FF>
<th>Schedule ID</th>
<th>Action</th>
</tr>
<c:forEach items="${j}" var="i"> 
<tr>
<td>${i.scheduleID}</td>
<td><a href="/ShippingReservationSystem/reserve?id=${i.scheduleID}">Book</a></td>
</tr>
</c:forEach>
</table>
</td>
</tr>
</table>
</center>
</form:form>
<center><a href="/ShippingReservationSystem/chome">Go Home</a></center>
</body>
</html>