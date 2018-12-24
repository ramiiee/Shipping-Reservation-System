<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body background="C:\Users\Administrator\Downloads\welcome.jpg" alink="black" vlink="black">

<h1><center>${id}</center></h1>
<h1><center><font face="Freestyle Script" size="20">Welcome </font></center></h1>  

<font face="Times New Roman" size="3">
<div align="center">
<br>
<a href="Viewby">Ships Available</a> &nbsp &nbsp  <a href="canceltkt">Cancel Ticket</a> &nbsp &nbsp <a href="viewtkt">View Ticket</a>
<br>
Change Password ? <a href="change">Click Here</a>
<form name="logout" method="post" action="logout">
<center><input type="submit"value="logout"/></center>
</form>
</div>
</font>
</body>
</html>