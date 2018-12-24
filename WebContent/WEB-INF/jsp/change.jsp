 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password Change</title>
</head>
<body bgcolor=#33CCCC>
<h1 align="center">Change Password</h1>
<form:form method="POST" action="/ShippingReservationSystem/changePassword">
<table align="center">
<tr>
<td>User ID</td><td><input type="text" name="userID"/></td></tr>
<tr>
<td>New Password</td><td><input type="password" name="newPassword"/></td></tr>
</table>
<div align="center">
<input type="submit" value="Submit"/>
</div>
</form:form>
</body>
</html>