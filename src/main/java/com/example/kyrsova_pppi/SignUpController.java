package com.example.kyrsova_pppi;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.kyrsova_pppi.assets.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SignUpButton;

    @FXML
    private CheckBox SignUpCheakBoxFemale;

    @FXML
    private CheckBox SignUpCheakBoxMale;

    @FXML
    private PasswordField SignUpCountry;

    @FXML
    private PasswordField SignUpLogin;

    @FXML
    private TextField SignUpName;

    @FXML
    private PasswordField SignUpPassword;

    @FXML
    private TextField SignUpSoname;

    @FXML
    void initialize() {
        SignUpButton.setOnAction(event -> {

            SignUpNewUser();
            



        });
    }

    private void SignUpNewUser() {
        DBhenler dbHandler = new DBhenler();

        String firstName = SignUpName.getText();
        String secondName = SignUpSoname.getText();
        String username = SignUpLogin.getText();
        String password = SignUpPassword.getText();
        String location = SignUpCountry.getText();
        String gender = "";
        if(SignUpCheakBoxMale.isSelected())
            gender = "Чоловік";
        else
            gender = "Жінка";

        User user = new User(firstName, secondName, username, password, location, gender);

        dbHandler.signUpUser(user);
    }
}

