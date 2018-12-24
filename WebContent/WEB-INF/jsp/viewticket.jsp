
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Ticket</title>
</head>
<body bgcolor=#33CCCC>
<h4 align="center">View Ticket</h4>
<form:form method="POST" action="/ShippingReservationSystem/viewTicket">
   <table align="center">
    
    <tr>
    	<td><form:label path="reservationID">Enter the reservation ID</form:label></td>
        <td><form:input path="reservationID" /></td>
    </tr>
            
 	</table>  
<div align="center">
 <input type="submit" value="View Ticket"/>
 <br>
 <a href="/ShippingReservationSystem/chome">Back</a>
</div>
</form:form>
</body>
</html>