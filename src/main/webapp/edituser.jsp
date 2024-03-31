<%@page import="org.example.crud.*,java.util.*"%>
<jsp:useBean id = "p" class = "org.example.crud.Person"></jsp:useBean>
<jsp:setProperty property = "*" name= "p"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%

int temp = PersonDao.update(p);
response.sendRedirect("viewusers.jsp");
%>