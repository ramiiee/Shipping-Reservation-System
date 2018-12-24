<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passenger List</title>
</head>
<body background="C:\Users\Administrator\Downloads\g.jpg">
<center>
<h1>Passenger Tracking System</h1>
<form:form method="POST" action="/ShippingReservationSystem/viewdPF">
   <table>
    <tr>
        <td><form:label path="scheduleID">Schedule ID</form:label></td>
        <td><form:input path="scheduleID" /></td>
    </tr>
     <tr>
        <td colspan="2">
            <input type="submit" value="View Passengers"/>
        </td>
    </tr>
   
        

</table>  

</form:form>
</center>

</body>
</html>