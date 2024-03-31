package org.example.crud;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class PersonDao {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/shop";
    static final String USER = "postgres";
    static final String PASS = "seva";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Подключение прошло успешно");

        } catch (Exception e2) {
            System.out.println(e2);
        }
        return connection;
    }

    //метод отвечает за вытаскивание информации и сохранение ее в базу
    //в качестве аргумента персон
    public static int save(Person person) {
        //в качестве результата возвращает 0,те персона в базу не сохранили
        int status = 0;
        try {
            Connection connection = PersonDao.getConnection();
            //PreparedStatement preparedStatement = connection.prepareStatement("insert into crud_example (userName,userPass,userEmail,userCountry, role) values(?,crypt (?,'nothing'),?,?,?)");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into crud_example (userName,userPass,userEmail,userCountry, role) values(?,?,?,?,?)");
            preparedStatement.setString(1, person.getUserName());
            preparedStatement.setString(2, person.getUserPass());
            preparedStatement.setString(3, person.getUserEmail());
            preparedStatement.setString(4, person.getUserCountry());
            preparedStatement.setString(5, person.getUserRole().name());
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;

    }

    //выводим на отображение всех пользователей из базы
    public static ArrayList<Person> getAllPersons() {
        ArrayList<Person> arrayList = new ArrayList<>();

        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from crud_example");
            //пройдемся по всем элементам в базе и выполняем запрос
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt(1));
                person.setUserName(resultSet.getString(2));
                person.setUserPass(resultSet.getString(3));
                person.setUserEmail(resultSet.getString(4));
                person.setUserCountry(resultSet.getString(5));
                arrayList.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return arrayList;
    }

    //метод по удалению
    public static int delete(Person person) {
        int status = 0;

        try {
            //производим подключение
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from crud_example where id =?");
            preparedStatement.setInt(1, person.getId());
            //выполняем команду
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return status;
    }

    //методы по обновлению пароля
    public static Person getPersonById(int id) {
        Person person = new Person();

        try {
            //производим подключение
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from crud_example where id = ?");
            preparedStatement.setInt(1, id);
            //пройдемся по всем элементам в базе и выполняем запрос
            ResultSet resultSet = preparedStatement.executeQuery();
            //будем перебирать все значения(до тех пор пока они есть) и сохранять внутрь параметров
            if (resultSet.next())
                person.setId(resultSet.getInt(1));
            person.setUserName(resultSet.getString(2));
            person.setUserPass(resultSet.getString(3));
            person.setUserEmail(resultSet.getString(4));
            person.setUserCountry(resultSet.getString(5));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//вытащили инфу о пользователе
        return person;
    }

    //отправляем персона в метод update, чтобы отсюда вытащить все поля которые у нас есть.
    //Поэтому метод в качестве аргумента получает объект класса персон
    public static int update(Person person) {
        int status = 0;
        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update crud_example set userName=?, userPass=?, userEmail=?, userCountry=? where id = ?");
            preparedStatement.setString(1, person.getUserName());
            String hashedPass = getHashedPassword(person.getUserPass());
            preparedStatement.setString(2, hashedPass);
            System.out.println(hashedPass);
            preparedStatement.setString(3, person.getUserEmail());
            preparedStatement.setString(4, person.getUserCountry());
            preparedStatement.setInt(5, person.getId());
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
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

    public static Person checkPersonIfExists(Person person) {
        int status = 0;
        try {
            //создаем объект подключения
            Connection connection = PersonDao.getConnection();
            //создаем подготовленный запрос
            PreparedStatement preparedStatement = connection.prepareStatement("select * from crud_example where userEmail=? and userPass=?");
            preparedStatement.setString(1, person.getUserEmail());
            preparedStatement.setString(2, person.getUserPass());
//
            //с помощью ResultSet перебираем все поля пользователя
            ResultSet resultSet = preparedStatement.executeQuery();
            //до тех пор пока есть элементы внутри resultSet
            if (resultSet.next()) {
                person.setId(resultSet.getInt(1));
                person.setUserName(resultSet.getString(2));
                person.setUserPass(resultSet.getString(3));
                person.setUserEmail(resultSet.getString(4));
                person.setUserCountry(resultSet.getString(5));
                if ("ADMIN".equals(resultSet.getString(6))) {
                    person.setUserRole(Role.ADMIN);
                } else if("USER".equals(resultSet.getString(6))) {
                    person.setUserRole(Role.USER);
                }
//
                //если все отработало,получим заполненную информацию о пользователе
                return person;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
// метод, который возвращает список объектов типа Person в зависимости от role  и id
    public static ArrayList<Person> getFilteredPersons(String role, Integer id) {
        System.out.println(role);
        System.out.println(id);
        // Если роль "ADMIN", то возвращаем полный список объектов
        if ("ADMIN".equals(role)) {
            return PersonDao.getAllPersons();
            // Если роль не "ADMIN", создаем новый список
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(PersonDao.getPersonById(id));
            return arrayList;
        }
    }

}




