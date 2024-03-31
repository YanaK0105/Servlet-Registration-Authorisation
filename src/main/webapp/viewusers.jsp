<%@page import="org.example.crud.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Persons</title>
    <link rel="stylesheet" href="viewusers.css">
</head>
<body>
<div>
<h1 class="name">Persons lists</h1>
</div>
<%
ArrayList<Person> arrayList = PersonDao.getAllPersons();
request.setAttribute("arrayList",arrayList);
%>
<div class="table">
<table>
<tr>
<td>Id:</td>
<td>Name:</td>
<td>PassWord:</td>
<td>Email:</td>
<td>Country:</td>
</tr>
<c:forEach items="${arrayList}" var="person">
<tr>
<td>${person.getId()}</td>
<td>${person.getUserName()}</td>
<td>${person.getUserPass()}</td>
<td>${person.getUserEmail()}</td>
<td>${person.getUserCountry()}</td>
<td><a href ="editform.jsp?id=${person.getId()}">edit</a></td>
<td><a href = "deleteuser.jsp?id=${person.getId()}">delete</a></td>
</tr>
</c:forEach>
</table>
<p></p>
<a href ="index.html">Add new Person</a>
</body>
</html>