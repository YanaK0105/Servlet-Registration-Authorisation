<%@page import="org.example.crud.*,java.util.*"%>
<jsp:useBean id = "p" class = "org.example.crud.Person"></jsp:useBean>
<jsp:setProperty property = "*" name = "p"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String id = request.getParameter("id");
Person person = PersonDao.getPersonById(Integer.parseInt(id));
PersonDao.delete(p);
response.sendRedirect("viewusers.jsp");
%>