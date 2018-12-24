
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Ticket</title>
</head>
<body bgcolor=#33CCCC>
<center><h2>Ticket Cancellation</h2></center>
<form:form method="POST" action="/ShippingReservationSystem/cancel">
   <table align="center">
    <tr>
    	<td><form:label path="reservationID">Enter reservation ID</form:label></td>
        <td><form:input path="reservationID" /></td>
    </tr>
   </table> 
<div align="center"><input type="submit" value="Cancel Ticket"/></div> 
</form:form>
</body>
</html>