package com.example.kyrsova_pppi;

import com.example.kyrsova_pppi.assets.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBhenler extends Configs{
    Connection dbConnection;

private static String url = "jdbc:mysql://localhost:3306/kyrsova";
    private static String username = "root";
    private static String password = "23145768Fynjirf";

    public static Connection getDbConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void signUpUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + "," +
                Const.USERS_SECONDNAME + "," + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," +
                Const.USERS_LOCATION + "," + Const.USERS_GENDER + ")" + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getSecondName());
            prSt.setString(3, user.getUserName());
            prSt.setString(4, user.getPassword());
            prSt.setString(5, user.getLocation());
            prSt.setString(6, user.getGender());

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserById(int id){
        try (Connection connection = DBhenler.getDbConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE idusers = ?")){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            User user = new User();
            if (rs.next()){
                int idUser = rs.getInt(1);
                String firstName = rs.getString(2);
                String secondName = rs.getString(3);
                String userName = rs.getString(4);
                String password = rs.getString(5);
                String location = rs.getString(6);
                String gender = rs.getString(7);
                user.setId(idUser);
                user.setUserName(userName);
                user.setFirstName(firstName);
                user.setSecondName(secondName);
                user.setPassword(password);
                user.setLocation(location);
                user.setGender(gender);
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_USERNAME + "=? AND " + Const.USERS_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resSet;
    }
}
