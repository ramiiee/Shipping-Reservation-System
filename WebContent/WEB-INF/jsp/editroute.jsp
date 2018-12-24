<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
<body background="C:\Users\Administrator\Downloads\blue-water-ocean-sea-wallpaper.jpg">
<center><h2>Edit Details</h2></center>
<form:form method="POST" action="/ShippingReservationSystem/modifyr">
<center>
<table>
    <tr>
    	<td><form:label path="routeID">Route ID</form:label></td>
        <td><form:input path="routeID"/></td>
    </tr>
    <tr>
        <td><form:label path="source">Source</form:label></td>
        <td><form:input path="source" /></td>
    </tr>
   
    <tr>
    	<td><form:label path="destination">Destination</form:label></td>
        <td><form:input path="destination" /></td>
    </tr>
    
    <tr>
        <td><form:label path="travelDuration">TravelDuration</form:label></td>
        <td><form:input path="travelDuration" /></td>
   </tr>
   <tr>
        <td><form:label path="fare">Fare</form:label></td>
        <td><form:input path="fare" /></td>
   </tr> 
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit" />
        </td>
    </tr>
    
</table>
</center>
<center> <a href="admin">Go Home</a></center>
</form:form>
</body>
</html>