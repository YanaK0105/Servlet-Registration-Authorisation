package org.example.crud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@WebServlet("/reg")
public class Register extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        //нужен для того,чтобы мы могли отправить сообщение на нашу страничку
        PrintWriter printWriter = response.getWriter();

        String userName=request.getParameter("userName");
        String userPass=request.getParameter("userPass");
        String userEmail=request.getParameter("userEmail");
        String userCountry=request.getParameter("userCountry");


        // Hash the password
        String hashedPass = getHashedPassword(userPass);

        //создаем объект персона
        Person person = new Person();
        person.setUserName(userName);
        //person.setUserPass(userPass);
        person.setUserPass(hashedPass);
        person.setUserEmail(userEmail);
        person.setUserCountry(userCountry);
        person.setUserRole(Role.USER);
        System.out.println(userName);
        System.out.println(hashedPass);
        System.out.println(userEmail);
        System.out.println(userCountry);
        //сюда прокидываем персона,чтобы он пошел дальше по программе
        int status = PersonDao.save(person);
        if (status >0){
            printWriter.print("<h1 style='color:#c90e0e;position: absolute; z-index:100;'>User successfully saved</h1>");
            request.getRequestDispatcher("index.html").include(request,response);
        }
        else {
            printWriter.print("Something went wrong");
        }


        printWriter.close();
    }
    public static String getHashedPassword(String userPass) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hash = md.digest(userPass.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}


