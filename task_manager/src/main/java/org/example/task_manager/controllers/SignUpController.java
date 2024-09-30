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

private FXMLLoader root;

private Stage stage;

private Scene scene;


@FXML
    public void signUp(ActionEvent event) throws IOException {

    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setContentText("The passwords should be te same");
    UserDAOImpl userDAOImpl = new UserDAOImpl();
    int currentUserId;

    String userEmail = email.getText();
    String login = username.getText();
    String userPassword = password.getText();
    String confirmationPassword = passwordConfirmation.getText();

if(userPassword.equals(confirmationPassword)) {
    User createdUser = userDAOImpl.create(new User(login, userPassword,userEmail));
    currentUserId = createdUser.getId();
    alert.setContentText("Registration completed!");
    alert.showAndWait();

    root = new FXMLLoader(getClass().getResource("/org/example/task_manager/task-manager.fxml"));

    TaskManagerController controller = root.getController();
    controller.setUserId(currentUserId);

    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root.load());
    stage.setScene(scene);
    stage.show();

    //TO-DO:
    // pass the user id to the TaskManagerController

} else {
    alert.showAndWait();
}

}



}
