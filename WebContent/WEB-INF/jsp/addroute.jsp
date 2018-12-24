 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ship Registry</title>
</head>
<body background="C:\Users\Administrator\Downloads\g.jpg">
<form:form method="POST" action="/ShippingReservationSystem/addRoute">
<center><h1>Enter Route Details</h1></center>
<table align="center">
<tr>
source<input type="text" name="source"/></tr>
<tr>
<td align="center">destination<input type="text" name="destination"/></td></tr>
<tr>
<td align="center">travelDuration<input type="text" name="travelDuration"/></td></tr>
<tr>
<tr>
<td align="center">fare<input type="text" name="fare"/></td></tr>
<tr>
        <td colspan="2">
            <input type="submit" value="Add Route"/>
        </td>
   </tr>
   </table>
   <br>
   <br>
   <center>
   <a href="admin">Go Home</a>
   </center>    

</form:form>
</body>
</html>