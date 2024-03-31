<%@page import="org.example.crud.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="authed_person.css">
</head>
<p>
<img alt="image didn't load" src="<%=request.getContextPath()%>/upload/k8L2p_eQb5s.jpg" width="215" height="215" align="left">
</p>
<body>
<%
HttpSession httpSession = request.getSession();
if(session == null){
	response.sendRedirect("auth.html");
}
else {
String userName = (String) httpSession.getAttribute("userName");
String userEmail = (String) httpSession.getAttribute("userEmail");
String userCountry = (String) httpSession.getAttribute("userCountry");
}
%>
<div class="logout">
<div>
<h3>Hello ${sessionScope.userName}</h3>
Your data:
<p>Your name ${sessionScope.userName}</p>
<p>Your email ${sessionScope.userEmail}</p>
<p>Your country ${sessionScope.userCountry}</p>
<form action="logout" method="post">
<input type="submit" value="Logout" >
</div>
</div>

<%
ArrayList<Person> arrayList = PersonDao.getFilteredPersons((String) httpSession.getAttribute("userRole"), (Integer) httpSession.getAttribute("userId"));
request.setAttribute("arrayList",arrayList);
request.setAttribute("isAdmin", "ADMIN".equals((String) httpSession.getAttribute("userRole")));
%>

<c:if test="${isAdmin}">
<br/>
<br/>
<br/>
<a href="reg.html">register new user</a>
</c:if>

<h1 class="name">Persons lists</h1>
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
<c:if test="${isAdmin}">
    <td><a href = "deleteuser.jsp?id=${person.getId()}">delete</a></td>
</c:if>
</tr>
</c:forEach>
</table>
<p>
<a href="index.html" >Welcome</a>
</p>
</form>

</body>
</html>