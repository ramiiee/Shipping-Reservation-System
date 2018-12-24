<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passenger List</title>
</head>
<body background="C:\Users\Administrator\Downloads\g.jpg">
<center><h1>Passenger Manifesto</h1>
<table border="1">
<tbody>
<tr>
<td>Reservation ID</td>
<td>Schedule ID</td>
<td>Name</td>
<td>Gender</td>
<td>Age</td>
</tr>
 <c:forEach var="l" items="${pblist}">
<tr>
   <td><center><c:out value="${l.reservationID}" /></center></td>
      <td><center><c:out value="${l.scheduleID}" /></center></td>
  <td><center><c:out value="${l.name}" /></center></td>
   <td><center><c:out value="${l.gender}" /></center></td>
   <td><center><c:out value="${l.age}" /></center></td>
         </tr>
    </c:forEach>
   </tbody>
    </table>
    </center>
    <center> <a href="admin">Go Home</a></center>
</body>
</html>