<%@page import="org.example.crud.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Person info</title>
    <link rel="stylesheet" href="formareg.css">
</head>
<body>
<%
String id = request.getParameter("id");
Person person = PersonDao.getPersonById(Integer.parseInt(id));
%>
<div class="regform">
<br>
<br>
<br>
<br>
<h1 class = "name">Update Person info</h1>
<form action="edituser.jsp" method="post">
<input type="hidden" name="id" value="<%=person.getId()%>"
    <table>
        <p></p>
        <tr><td><p>Name:</p></td><td><input type="text"  placeholder="Enter username" name="userName" value="<%=person.getUserName()%>"/></td></tr>
        <p></p>
        <tr><td>Password:</td><td><input type="password" placeholder="Enter username" name="userPass" value="<%=person.getUserPass()%>"/></td></tr>
        <p></p>
        <tr><td><p>Email:</p></td><td><input type="email" placeholder="Enter email" name="userEmail" value="<%=person.getUserEmail()%>"/></td></tr>
        <p></p>
        <tr><td><p>Country:</p></td><td>
            <select name="userCountry" style="width:150px" >
                <option>-- Select a country --</option>
                <option>India</option>
                <option>USA</option>
                <option>UK</option>
                <option>Russia</option>
                <option>Germany</option>
                <option>Other</option>
            </select>
            <p></p>
        </td></tr>
        <tr><td colspan="2">
            <div class="submitBotton">
                <input type="submit" value="Edit">
            </div>
        </td></tr>
    </table>
</form>

<br/>

</div>
</body>
</html>