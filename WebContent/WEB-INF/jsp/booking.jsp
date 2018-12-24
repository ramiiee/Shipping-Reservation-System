<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking</title>
</head>
<body bgcolor=#33CCCC>
<center><h1><font face="Freestyle Script">The Shipping Company</font></h1></center>
<form:form method="POST" action="/ShippingReservationSystem/book">
<center>
<table>
    <tr>
    	<td><form:label path="name">Passenger Name</form:label></td>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <td><form:label path="age">Age</form:label></td>
        <td><form:input path="age" /></td>
    </tr>
   
    <tr>
         <td>Gender</td>
        <td><form:radiobutton path="gender" value="M"/>Male</td> 
        <td><form:radiobutton path="gender" value="F"/>Female</td> 

    </tr>
  </table>
</center>
<div align="center">
<input type="submit" value="Book" />
</div>
</form:form>
<form method="POST" action="/ShippingReservationSystem/confirmbooking">
<div align="center">
<input type="submit" value="Confirm"/>
</div>
</form>
</body>
</html>