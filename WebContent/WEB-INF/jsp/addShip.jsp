 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ship Registry</title>
</head>
<h1><center>Ship Management System</center></h1>
<h2><center>Add Ships to Fleet</center></h2>
<body background="C:\Users\Administrator\Downloads\g.jpg">
<form:form method="POST" action="/ShippingReservationSystem/addShip">
<table align="center">
<tr align="center">
<td>Ship Name <input type="text" name="shipName"/></td></tr>
<tr align="center">
<td>SeatingCapacity<input type="text" name="seatingCapacity"/></td></tr>
<tr>
<td>ReservationCapacity<input type="text" name="reservationCapacity"/></td></tr>
<tr align="center">
        <td colspan="2">
            <input type="submit" value="Add Ship"/>
        </td>
   </tr>
   </table>
   <br>
   <br>
  <center> <a href="admin">Go Home</a> </center>
       

</form:form>
</body>
</html>