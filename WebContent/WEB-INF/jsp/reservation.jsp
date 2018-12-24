<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation</title>
</head>
<body>
<h1><center>Reservation</center></h1>
<form:form method="POST" action="/ShippingReservationSystem/reserve">
   <table align="center">
    <tr>
    	<td><form:label path="userID">User ID</form:label></td>
        <td><form:input path="userID" /></td>
    </tr>
    <tr>
        <td><form:label path="scheduleID">Schedule ID</form:label></td>
        <td><form:input path="scheduleID" /></td>
    </tr>
     <tr>
        <td><form:label path="bookingDate">Booking Date</form:label></td>
        <td><form:input path="bookingDate" /></td>
    </tr>
     <tr>
        <td><form:label path="journeyDate">Journey Date</form:label></td>
        <td><form:input path="journeyDate" /></td>
    </tr>
     <tr>
        <td><form:label path="noOfSeats">No.Of Seats</form:label></td>
        <td><form:input path="noOfSeats" /></td>
    </tr>
     <tr>
        <td><form:label path="totalFare">Total Fare</form:label></td>
        <td><form:input path="totalFare" /></td>
    </tr>
    <tr>
        <td><form:label path="bookingStatus">Booking Status</form:label></td>
        <td><form:input path="bookingStatus" /></td>
    </tr>
   
    <tr>
        <td colspan="2">
            <input type="submit" value="Add More Passengers"/>
              
        </td>
    </tr>
</table>  
</form:form>
<form:form method="POST" action="/ShippingReservationSystem/login1">
<table>
<tr>
        <td colspan="2">
            <input type="submit" value="Make Booking"/>
              
        </td>
    </tr>
</table>
</form:form>
</body>
</html>