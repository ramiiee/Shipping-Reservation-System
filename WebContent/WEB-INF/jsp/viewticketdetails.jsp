<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:f="http://java.sun.com/jsf/core"      
      xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Ticket</title>
<h1 align="center"><font face="Freestyle Script">The Shipping Company</font></h1>
<h2 align="center">Your Ticket</h2>
</head>
<body bgcolor=#33CCCC>
<h:form>

<table align="center">
<tr>
<td>Reservation Id: <c:forEach items="${rb}" var="a">${a.key.reservationID}</c:forEach></td></tr>
<tr>
<td>User-Id:<c:forEach items="${rb}" var="a">${a.key.userID}</c:forEach></td></tr>
<tr>
<td>Journey Date:<c:forEach items="${rb}" var="a">${a.key.journeyDate}</c:forEach></td></tr>
<tr>
<td>Total Fare:<c:forEach items="${rb}" var="a">${a.key.totalFare}</c:forEach></td></tr>


</table>

<table border="2" align="center">

<tr>
<th>Name</th>
<th>Gender</th>
<th>Age</th>
</tr>


<c:forEach items="${rb}" var="a">
<tr>
<td>${a.value.name}</td>
<td>${a.value.gender}</td>
<td>${a.value.age}</td>
</tr>

</c:forEach>
 </table>
</h:form></body>
<div align="center">
 <a href="/ShippingReservationSystem/chome">Home</a>
</div>
</html>