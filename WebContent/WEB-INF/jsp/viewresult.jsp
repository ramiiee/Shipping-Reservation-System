<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<h1><center>Ship Management System</center></h1>
<h2><center>Selected Ship</center></h2>
<body background="C:\Users\Administrator\Downloads\g.jpg">
<form:form>
<table border="1">
 
<tr>
<th>ShipID</th>
<th>ShipName</th>
<th>Seating Capacity</th>
<th>Reservation Capacity</th>
<th>Action1</th>
<th>Action2</th>
</tr>
<tr>
<td>${s.shipID}</td>
<td>${s.shipName}</td>
<td>${s.seatingCapacity}</td>
<td>${s.reservationCapacity}</td>
<td><a href="editcontr?id=${s.shipID}">Edit</a></td>
<td><a href="delete">Delete</a></td>	
</tr>

</table>
<a href="admin">Go Home</a>
</form:form>
</body>
</html>