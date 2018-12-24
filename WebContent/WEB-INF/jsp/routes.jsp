<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="C:\Users\Administrator\Downloads\g.jpg">
<form:form>
<table border="1">
 
<tr>
<th>RouteID</th>
<th>Source</th>
<th>Destination</th>
<th>Travel Duration</th>
<th>Fare</th>
<th>Action1</th>
<th>Action2</th>
</tr>
<tr>
<td>${r.routeID}</td>
<td>${r.source}</td>
<td>${r.destination}</td>
<td>${r.travelDuration}</td>
<td>${r.fare}</td>
<td><a href="editrcontr?id=${r.routeID}">Edit</a></td>
<td><a href="">Delete</a></td>	
</tr>

</table>
<a href="admin">Go Home</a>
</form:form>
</body>
</html>