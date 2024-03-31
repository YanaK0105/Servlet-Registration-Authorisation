package org.example.crud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/delete")
//public class DeletePerson extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //получаем инфу из нашего id
//        String tempId = req.getParameter("id");
//        //преобразвуем строковый формат в целочисленный.тк id это целое число
//        int id = Integer.parseInt(tempId);
//        //вызываем метод удаления
//        PersonDao.delete(id);
//        //выводим информацию после удаления,перенаправляем по манигу view
//        resp.sendRedirect("view");
//    }
//}