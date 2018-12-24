<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="C:\Users\Administrator\Downloads\g.jpg">
<center> <h1><font face="lucida console" size=20 color=#5A0000>WELCOME ADMIN</font></h1>

     <h2>Tasks</h2>
<table>
<tr><th>Ship</th>
<th>Route</th>
<th>Schedule</th>
<th>Passengers</th>
</tr>

<tr><td><a href="addShip">Add Ship to Fleet</a></td><td><a href="addRoute">Add Route</a></td><td><a href="scheduleAdd">Add Schedule</a></td><td><a href="viewPF">View Passengers by Schedule</a></td></tr>
<tr><td><a href="view">View by ShipID</a></td><td><a href="viewRoute">View by RouteID</a></td><td><a href="viewSchedule">View by Schedule ID</a></td></tr>
<tr><td><a href="viewAllcontr">View All Ships</a></td><td><a href="viewAllRcontr">View All Routes</a></td><td><a href="viewAllScontr">View All Schedules</a></td></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>

</table>
</center>
<br>
<form name="logout" method="post" action="logout">
<center><input type="submit"value="logout"/></center>
</form>
</body>
</html>