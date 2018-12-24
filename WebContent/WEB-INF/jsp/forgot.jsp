 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
</head>
<script>
function validate()
{
	var x = document.getElementById("password");
	var y = document.getElementById("cpassword");
if (x.value != y.value) { 
	   alert("Your password and confirmation password do not match.");
	   cpassword.focus();
	   return false; 
	}
}
</script>
<h1 align="center">Reset Password</h1>
<body bgcolor=#33CCCC>
<form:form method="POST" action="/ShippingReservationSystem/forgot">
 <table>
    <tr>
        <td><form:label path="userID">UserID</form:label></td>
        <td><form:input path="userID"  /></td>
    </tr>
    <tr>
        <td><form:label path="password" >NewPassword</form:label></td>
        <td><form:password path="password" id="password" /></td>
    </tr>
    <tr>
        
<td>Confirm Password</td><td><input type="password" id="cpassword" onblur="validate()"/></td>
</tr>
     <tr>
        <td><form:label path="mobileNo" >MobileNo</form:label></td>
        <td><form:input path="mobileNo" /></td>
    </tr>
    <tr>
    
        <td colspan="2">
            <input type="submit" value="confirm"/>
        </td>
    </tr>
</table> 
</form:form>
</body>
</html>