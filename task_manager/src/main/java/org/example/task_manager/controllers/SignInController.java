package org.example.task_manager.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.task_manager.dao.UserDAO;
import org.example.task_manager.dao.implementations.UserDAOImpl;
import org.example.task_manager.entities.User;


import java.io.IOException;


public class SignInController {
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    private Stage stage;

    private Scene scene;

    private FXMLLoader root;




    @FXML
    public void signIn(ActionEvent event) throws IOException {
        UserDAOImpl userDAOImpl = new UserDAOImpl();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Wrong login or password. Please try again...");

        String login = username.getText();
        String userPassword = password.getText();
        User foundUser = userDAOImpl.findByLogin(login);

if(foundUser.getPassword().equals(userPassword)) {
    root = new FXMLLoader(getClass().getResource("/org/example/task_manager/task-manager.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root.load());
    stage.setScene(scene);
    stage.show();
} else {
    alert.showAndWait();
}

    }

    @FXML
    public void changeToSignUp(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/task_manager/sign-up.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }



}