package com.example.kyrsova_pppi;

import com.example.kyrsova_pppi.assets.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DBhenlerTest {

    private DBhenler dBhenler;
    @BeforeEach

    public void getDBhendler() {
        dBhenler = new DBhenler();
    }

    @Test
    void signUpUser() {
        User userToAdd = new User("FirstName", "LastName", "userName", "password", "Kiev", "ukrainets");
        dBhenler.signUpUser(userToAdd);

    }

    @Test
    void getUserById() {
        User userToAdd = new User("FirstName", "LastName", "userName", "password", "Kiev", "ukrainets");
        dBhenler.signUpUser(userToAdd);
        User result = dBhenler.getUserById(getMaxIdFromDB());
        assertEquals(userToAdd.getUserName(), result.getUserName());
        assertEquals(userToAdd.getLocation(), result.getLocation());
        assertEquals(userToAdd.getGender(), result.getGender());
        assertEquals(userToAdd.getFirstName(), result.getFirstName());
        assertEquals(userToAdd.getSecondName(), result.getSecondName());
    }

     int getMaxIdFromDB(){
        try (Connection connection = DBhenler.getDbConnection(); PreparedStatement statement = connection.prepareStatement("SELECT MAX(idusers) FROM users")){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                return  rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
}