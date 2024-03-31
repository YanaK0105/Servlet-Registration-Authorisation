package org.example.crud;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

//public class AuthHass extends HttpServlet {

  // @Override
  // public void doPost(HttpServletRequest request, HttpServletResponse response)
  //         throws ServletException, IOException {
//
      //response.setContentType("text/html");
      //PrintWriter printWriter = response.getWriter();

      //String userEmail = request.getParameter("userEmail");
      //String userPass = request.getParameter("userPass");
// Хеширование пароля с использованием MD5


       // Генерация соли
       //String salt = generateSalt();
       //// Хеширование пароля
       //String hashedPassword = hashPassword(userPass, salt);
       //String userPass =
//
       //boolean isMatched = verifyPassword(userPass, salt, hashedPassword);
       //if (isMatched) {
       //    System.out.println("Пароли совпадают!");
       //} else {
       //    System.out.println("Пароли не совпадают!");
       //}
       //// Метод для генерации случайной соли
      // () {
          // // генерации соли
          // byte[] salt = new byte[16];
          // SecureRandom secureRandom = new SecureRandom();
          // secureRandom.nextBytes(salt);
          // return salt;
          // // Возвращаем пример случайной соли (для наглядности)
      // }
       // Метод для хеширования пароля с использованием MD5 и соли
      //private static String hashPassword (String userPass, String salt){
      //    String hashedPassword = null;
      //    try {
      //        // Создание экземпляра объекта MessageDigest с алгоритмом MD5
      //        MessageDigest md = MessageDigest.getInstance("MD5");
      //        // Конкатенация пароля и соли
      //        String passwordWithSalt = userPass + salt;
      //        // Преобразование пароля с солью в массив байт, затем хеширование
      //        md.update(passwordWithSalt.getBytes());
      //        byte[] digest = md.digest();
      //        // Преобразование массива байт в шестнадцатеричную строку
      //        StringBuilder sb = new StringBuilder();
      //        for (byte b : digest) {
      //            sb.append(String.format("%02x", b & 0xff));
      //        }
      //        hashedPassword = sb.toString();
      //    } catch (NoSuchAlgorithmException e) {
      //        e.printStackTrace();
      //    }
      //    return hashedPassword;
      //}
       // Метод для проверки соответствия пароля с введенной строкой
 //      private static boolean verifyPassword (String userPass, String salt, String hashedPassword){
 //          String inputHashedPassword = hashPassword(userPass, salt);
 //          return inputHashedPassword.equals(hashedPassword);
 //      }
 //  }
//