package org.example.crud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

@WebServlet("/auth")
public class Auth extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        String userEmail = request.getParameter("userEmail");
        String userPass = request.getParameter("userPass");
        System.out.println(userPass);
        System.out.println(userEmail);
        // Hash the password
        String hashedPass = getHashedPassword(userPass);

        Person person = new Person();
        //person.setUserPass(userPass);
        person.setUserPass(hashedPass);
        person.setUserEmail(userEmail);
        //проверка пароля
        //хешируем полученный из формочки пароль
        System.out.println(hashedPass);
        System.out.println(userEmail);

        //сравниваем введенный пароль с хранящимся в базе

// выполним проверку есть у нас такой person
        if (PersonDao.checkPersonIfExists(person) != null) {
            //внутри объекта returnedPerson будет храниться информация о всех полях нашего пользователя
            Person returnedPerson = PersonDao.checkPersonIfExists(person);
            // создаем объект сессии
            HttpSession httpSession = request.getSession();
            // прокидываем аргументы для сессии конкретного пользователя
            httpSession.setAttribute("userName", returnedPerson.getUserName());
            httpSession.setAttribute("userEmail", returnedPerson.getUserEmail());
            httpSession.setAttribute("userId", returnedPerson.getId());
            httpSession.setAttribute("userCountry", returnedPerson.getUserCountry());
            httpSession.setAttribute("userPass", returnedPerson.getUserPass());
            //System.out.println(returnedPerson.getUserRole());
            //System.out.println(returnedPerson.getUserRole().toString());
            //System.out.println(returnedPerson.getUserRole().name());
            httpSession.setAttribute("userRole", returnedPerson.getUserRole().name());
            System.out.println(returnedPerson.getUserName());
            System.out.println(returnedPerson.getUserEmail());
            System.out.println(returnedPerson.getUserPass());
            System.out.println(returnedPerson.getUserCountry());
            response.sendRedirect("authed_person.jsp");
        } else {
            printWriter.print("<h1 style='color:#c90e0e;position: absolute; z-index:100;'>User auth error, incorrect email or password</h1>");
            request.getRequestDispatcher("auth.html").include(request, response);
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




