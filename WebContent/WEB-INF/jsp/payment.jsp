<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page session="true"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body bgcolor=#33CCCC>
<h1 align="center"><font face="Freestyle Script">The Shipping Company</font></h1>
<h2 align="center">Payment Gateway</h2>
<div align="center">
<h1>${id}</h1>

<h2>Reservation ID for ${i} is ${s}</h2>
<form:form method="POST" action="/ShippingReservationSystem/pay">
   <table border="2">
<tr>
        <td><form:label path="creditCardNumber">creditCardNumber</form:label></td>
        <td><form:input path="creditCardNumber" /></td>
    </tr>
 <%--    <tr>
        <td><form:label path="userID" >userID</form:label></td>
        <td><form:input path="userID" /></td>
    </tr> --%>
    <tr>
        <td colspan="2">
            <input type="submit" value="Pay"/>
        </td>
    </tr>
</table> 
</form:form>
<a href="/ShippingReservationSystem/chome">Cancel Booking</a>
 </div>
</body>
</html>