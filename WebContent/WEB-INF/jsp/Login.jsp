
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Login</title>
</head>
<body background="C:\Users\Administrator\Downloads\westerdam-ship-size.jpg" vlink=#00FF00 alink=#5EFF5E>
<h4>${id}</h4>
<center><h2><font face="Freestyle Script" size="20">The Shipping Company</font></h2></center>
<form:form method="POST" action="/ShippingReservationSystem/login1" target="_top">
   <table align="center">

    <tr>
    	<td><form:label path="userID">UserId</form:label></td>
        <td><form:input path="userID" /></td>
    </tr>
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:password path="password" /></td>
    </tr>
   
    <tr>
        <td colspan="2">
            
            <center><input type="submit" value="Login"/></center>         
              
        </td>
    </tr>
 
</table>  
</form:form>
<form:form method="GET" action="/ShippingReservationSystem/registration">
<table align="center">
<tr>
        <td colspan="2">
            <input type="submit" value="Register"/>
        </td>
    </tr>
</table>
</form:form>
<center><font color=#CCFF33>Forgot Password ?<a href="forgot">Click Here</a></font></center>
</body>
</html>