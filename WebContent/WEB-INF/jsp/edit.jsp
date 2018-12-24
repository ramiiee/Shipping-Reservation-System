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
<form:form method="POST" action="/ShippingReservationSystem/modify">
<center>
<table>
    <tr>
    	<td><form:label path="shipID">Ship ID</form:label></td>
        <td><form:input path="shipID"/></td>
    </tr>
    <tr>
        <td><form:label path="shipName">Ship Name</form:label></td>
        <td><form:input path="shipName" /></td>
    </tr>
   
    <tr>
    	<td><form:label path="seatingCapacity">Seating Capacity</form:label></td>
        <td><form:input path="seatingCapacity" /></td>
    </tr>
    
    <tr>
        <td><form:label path="reservationCapacity">Reservation Capacity</form:label></td>
        <td><form:input path="reservationCapacity" /></td>
   </tr> 
       
 </table></center>
			<div align="center">
            <input type="submit" value="Submit" />
      		</div>

<center> <a href="admin">Go Home</a></center>
</form:form>
</body>
</html>