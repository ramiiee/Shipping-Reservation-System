<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="POST" action="/ShippingReservationSystem/delete">
<center>
<table>
    <tr>
    	<td><form:label path="shipID">Ship ID</form:label></td>
        <td><form:input path="shipID"/></td>
    </tr>
</table>
</center>
</form:form>
</body>
</html>