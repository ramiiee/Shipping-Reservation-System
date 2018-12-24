<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View</title>
</head>
<body bgcolor=#33CCCC>

<h1><center><font face="Freestyle Script" size="6">View Ship Availability</font></center></h1>

<form:form method="POST"  action="/ShippingReservationSystem/check">

<font face="Times New Roman">
<table align="center">
<tr>
Source:<select name="source">
<option name="Chennai" value="Chennai">Chennai</option>
<option name="Mumbai" value="Mumbai">Mumbai</option>
<option name="Vizag" value="Vizag">Vizag</option>
<option name="Mangalore" value="Mangalore">Mangalore</option>
<option name="Cochin" value="Cochin">Cochin</option>
</select></tr>

<tr>
Destination:<select name="destination">

<option name="Chennai" value="Chennai">Chennai</option>
<option name="Mumbai" value="Mumbai">Mumbai</option>
<option name="Vizag" value="Vizag">Vizag</option>
<option name="Mangalore" value="Mangalore">Mangalore</option>
<option name="Cochin" value="Cochin">Cochin</option></select>
</select>
</tr>
<tr>
DateofJourney:<input type="text" name="date"/>
<input type="submit" value="Search"/>
</tr>
</table>
</font>
</form:form>
<center><a href="/ShippingReservationSystem/chome">Go Home</a></center>
</body>
</html>