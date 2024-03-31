package org.example.crud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/update")
//public class UpdatePass extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //получаем инфу из нашего id
//        //String tempId = req.getParameter("id");
//        //преобразвуем строковый формат в целочисленный.тк id это целое число
//        //int id = Integer.parseInt(tempId);
//        String userPass = req.getParameter("userPass");
//
//        //вызываем метод обновления
//        PersonDao.update(userPass);
//
//        //выводим информацию после обновления,перенаправляем по манигу view
//        resp.sendRedirect("view");
//    }
//}
