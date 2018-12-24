 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Registry</title>
</head>

<body background="C:\Users\Administrator\Downloads\g.jpg">
<h1 align="center">Enter Schedule Details</h1>
<form:form method="POST" action="/ShippingReservationSystem/addSchedule">
<table align="center">
<tr>
<td>Route ID<input type="text" name="routeID"/></td></tr>
<tr>
<td>Ship ID <input type="text" name="shipID"/></td></tr>
<tr>
<td>Start Date<input type="text" name="startDate"/></td></tr>
 </table>
   <br>
   <br>
   <center> <input type="submit" value="Add Schedule"/></center>
  <center> <a href="admin">Go Home</a></center>
       

</form:form>
</body>
</html>