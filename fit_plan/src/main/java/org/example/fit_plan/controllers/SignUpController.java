package org.example.fit_plan.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {

    @FXML
    private TextField emailField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField repeatedPasswordField;

    @FXML
    private Button signUpButton;

    @FXML
    private Button backButton;

    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    @FXML
    public void signUp(){

        String email = emailField.getText();
        String login = usernameField.getText();
        String password = passwordField.getText();
        String repeatedPassword = repeatedPasswordField.getText();



    }

    @FXML
    private void goToSignIn(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/sign-in.fxml"));

        scene = new Scene(root.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

}
