<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTRATION</title>
 
 <script> 

function checkEmail() {

    var email = document.getElementById('txtEmail');
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!filter.test(email.value)) {
    alert('Please provide a valid email address');
    email.focus;
    return false;
 }
}
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
function num()
{
var mobile = document.getElementById("n").value;
     if(mobile.length!=10)
     {
         alert("Enter 10 digits Contact Number.");
         return false;
     }
}
function isNumber()
{  
	var pin = document.getElementById("n1").value;
    var re = /^[0-9]+$/; 
    str = pin.toString();
    if(str.length!=6)
    	{
    	alert("pincode should have 6 digits ");
    	}
    if (!str.match(re)) 
    {   
    	alert("enter only number");
        return false;
    }
    return true;
}

	
</script>
</head>
<body background="C:\Users\Administrator\Downloads\blue-water-ocean-sea-wallpaper.jpg">
<center><h2>REGISTRATION</h2></center>
<form:form name="f1" method="POST" action="/ShippingReservationSystem/addCustomer" target="_top">
<center>
<table>
<tr><td><form:errors path="profilebean.*"></form:errors></td></tr>
    <tr>
    
        <td><form:label path="firstName"></form:label>FirstName</td>
        <td><form:input path="firstName"  /></td>
    </tr>
     <tr>
        <td><form:label path="lastName"></form:label>LastName</td>
        <td><form:input path="lastName"  /></td>
    </tr>
     <tr>
        <td><form:label path="gender"></form:label>Gender</td>
        <td><form:radiobutton path="gender" value="M"/>Male 
			<form:radiobutton path="gender" value="F"/>Female </td>
    </tr>
     <tr>
        <td><form:label path="dateOfBirth"></form:label>DateOfBirth</td>
        <td><form:input path="dateOfBirth" value="dd/mm/yyyy"   /></td>
    </tr>
     <tr>
        <td><form:label path="location"></form:label>Location</td>
        <td><form:input path="location"/></td>
    </tr>
     <tr>
        <td><form:label path="city"></form:label>City</td>
        <td><form:input path="city" /></td>
    </tr>
     <tr>
        <td><form:label path="street"></form:label>Street</td>
        <td><form:input path="street"/></td>
    </tr>
     <tr>
        <td><form:label path="state" ></form:label>State</td>
        <td><form:select path="state">
        <option value="Andhra Pradesh">AndhraPradesh</option>
	<option value="Arunachal Pradesh">Arunachal Pradesh</option>
	<option value="Assam">Assam</option>
	<option value="Bihar">Bihar</option>
	<option value="Chhattisgarh">Chhattisgarh</option>
	<option value="Goa">Goa</option>
	<option value="Gujarat">Gujarat</option>
	<option value="Haryana">Haryana</option>
	<option value="Himachal Pradesh">Himachal Pradesh</option>
	<option value="Jammu & Kashmir">Jammu & Kashmir</option>
	<option value="Jharkhand">Jharkhand</option>
	<option value="Karnataka">Karnataka</option>
	<option value="Kerala">Kerala</option>
	<option value="Maharashtra">Maharashtra</option>
	<option value="Manipur">Manipur</option>
	<option value="Meghalaya">Meghalaya</option>
	<option value="Mizoram">Mizoram</option>
	<option value="Nagaland">Nagaland</option>
	<option value="Odisha">Odisha</option>
	<option value="Punjab">Punjab</option>
	<option value="Rajasthan">Rajasthan</option>
	<option value="Sikkim">Sikkim</option>
	<option value="Tamil Nadu">Tamil Nadu</option>
	<option value="Telangana">Telangana</option>
	<option value="Tripura">Tripura</option>
	<option value="Uttar Pradesh">Uttar Pradesh</option>
	<option value="Uttarakhand">Uttarakhand</option>
	<option value="West Bengal">West Bengal</option>
	<option value="Tripura">Tripura</option>
	</form:select>
	</td>

    </tr>
    <tr>
        <td><form:label path="pincode" ></form:label>Pincode</td>
        <td><form:input path="pincode" id="n1" onblur="isNumber()"  /></td>
    </tr>
    <tr>
        <td><form:label path="mobileNo" ></form:label>MobileNo</td>
        <td><form:input path="mobileNo" id="n" onblur="num()" /></td>
    </tr>
     <tr>
        <td><form:label path="emailID" ></form:label>EmailID</td>
        <td><form:input path="emailID" id="txtEmail"  onblur=" checkEmail()" /></td>
    </tr>
<tr>
        <td><form:label path="password" ></form:label>Password</td>
        <td><form:input path="password" id="password"/></td>
</tr>
<tr>
        
<td>Confirm Password</td><td><input type="password" id="cpassword" onblur="validate()"/></td>
</tr>
 <tr>
        <td colspan="2">
            <h2><input type="submit" value="Register"/></h2>
        </td>
    </tr>
</table> </form:form>

</body>
</html>