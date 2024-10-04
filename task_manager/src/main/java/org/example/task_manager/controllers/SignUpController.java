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
import org.example.task_manager.dao.implementations.UserDAOImpl;
import org.example.task_manager.entities.User;

import java.io.IOException;

public class SignUpController {

@FXML
    private TextField email;

@FXML
    private TextField username;

@FXML
    private PasswordField password;

@FXML
    private PasswordField passwordConfirmation;

@FXML
    private Button signUpButton;

@FXML
private Button goBackButton;

private FXMLLoader root;

private Stage stage;

private Scene scene;


@FXML
    public void signUp(ActionEvent event) throws IOException {

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setContentText("The passwords should be te same");
    UserDAOImpl userDAOImpl = new UserDAOImpl();


    String userEmail = email.getText();
    String login = username.getText();
    String userPassword = password.getText();
    String confirmationPassword = passwordConfirmation.getText();

if(userPassword.equals(confirmationPassword)) {
    User createdUser = userDAOImpl.create(new User(login, userPassword,userEmail));

    alert.setContentText("Registration completed!");
    alert.showAndWait();

    root = new FXMLLoader(getClass().getResource("/org/example/task_manager/task-manager.fxml"));



    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root.load());
    TaskManagerController controller = root.getController();
    controller.setUser(createdUser);
    stage.setScene(scene);
    stage.show();


} else {
    alert.showAndWait();
}

}

    @FXML
    public void goBackToSignIn(ActionEvent event) throws IOException {

    root = new FXMLLoader(getClass().getResource("/org/example/task_manager/sign-in.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root.load());
    stage.setScene(scene);
    stage.show();

    }



}
