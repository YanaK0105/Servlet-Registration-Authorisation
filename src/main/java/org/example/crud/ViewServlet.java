package org.example.crud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//@WebServlet("/view")
//public class ViewServlet  extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //req.getRequestDispatcher("info_2.jsp").include(req,resp);
//        resp.setContentType("text/html");
//        //выводим информацию на печать
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.println("<a href='index.html'>Add New Person</a>");
//        //выведем информацию о пользователе
//        printWriter.print("<h1>Persons list</h1>");
//        //получаем информацию о нашем пользователе
//        ArrayList<Person> arrayList = PersonDao.getAllPersons();
//        //создаем таблицу,внутри которой будут отображаться наши данные
//        printWriter.print("<table>");
//        //создали строку с тремя столбцами
//        printWriter.print("<tr><td>id</td> <td>userName</td>  <td>userPass</td>  <td>userEmail</td>   <td>userCountry</td><th>delete</th><th>update</th></tr>");
//        //внутри цикла проходимся по всем элементам. Где элементы храняться внутри списка ArrayList,
//        // где каждый элемент является объектом класса person. И чтобы получить соответствующее поле,вызываем конструкцию person.getId() и тп
//        for (Person person :arrayList) {
//            printWriter.print("<tr><td>" + person.getId() +"</td> " +
//                    "<td>" + person.getUserName() +"</td> " +
//                    " <td>"+ person.getUserPass() +" </td> " +
//                    " <td>"+ person.getUserEmail() +"</td>  " +
//                    " <td>"+ person.getUserCountry() +"</td>" +
//                    "<th><a href ='EditServlet?id=" + person.getId() + "'>edit</a></th>" +
//                    "<th><a href = 'delete?id="+ person.getId() +"'>delete</a></th></tr>");
//        }
//        printWriter.print("</table>");
//    }
//}

//<%@page import="org.example.crud.*,java.util.*"%>

