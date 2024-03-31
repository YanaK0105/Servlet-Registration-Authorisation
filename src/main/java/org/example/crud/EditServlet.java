package org.example.crud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/EditServlet")
//public class EditServlet extends HttpServlet {
//@Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    resp.setContentType("text/html");
//    PrintWriter printWriter = resp.getWriter();
//    printWriter.print("<h1>Update Person info</h1>");
//    // из запроса вытаскиваем ид пользователя, которого хотим изменить
//    String sid = req.getParameter("id");
//    //приводим к целочисленному параметру. тк ид получаем из запроса как строку.
//    int id = Integer.parseInt(sid);
//    Person person = PersonDao.getPersonById(id);
//    printWriter.print("<form action='EditServlet2' method='post'>");
//    printWriter.print("<table>");
//    printWriter.print("<tr><td></td><td><input type='hidden' name='id' value='"+person.getId()+"'/></td></tr>");
//    printWriter.print("<tr><td>Name:</td><td><input type='text' name='userName' value='"+person.getUserName()+"'/></td></tr>");
//    printWriter.print("<tr><td>Password:</td><td><input type='password' name='userPass' value='"+person.getUserPass()+ "'/> </td></tr>");
//    printWriter.print("<tr><td>Email:</td><td><input type='email' name='userEmail' value='"+person.getUserEmail()+"'/></td></tr>");
//    printWriter.print("<tr><td>Country:</td><td>");
//    printWriter.print("<select name='userCountry' style='width:150px'>");
//    printWriter.print("<option>India</option>");
//    printWriter.print("<option>USA</option>");
//    printWriter.print("<option>UK</option>");
//    printWriter.print("<option>Other</option>");
//    printWriter.print("</select>");
//    printWriter.print("</td></tr>");
//    printWriter.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
//    printWriter.print("</table>");
//    printWriter.print("</form>");
//    }
//}
