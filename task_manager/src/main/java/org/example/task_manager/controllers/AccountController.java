package org.example.task_manager.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.task_manager.dao.implementations.UserDAOImpl;
import org.example.task_manager.entities.Task;
import org.example.task_manager.entities.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AccountController implements Initializable {

    @FXML
    private Label userNameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private PasswordField oldPassword;

    @FXML
    private PasswordField newPassword;

    @FXML
    private Button updatePasswordButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button backButton;

    private User user = new User();

    private Stage stage;

    private FXMLLoader root;

    private Scene scene;

    public void setUser(User user) {
        this.user = user;
    }


    @FXML
    public void updatePassword() {

        UserDAOImpl userDAOImpl = new UserDAOImpl();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Wrong password");
        alert.setContentText("Wrong password. Please try again! ");


        if (oldPassword.getText().equals(user.getPassword())) {


            user.setPassword(newPassword.getText());

            userDAOImpl.update(user);

            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Successful! ");
            alert.setContentText("Password updated successfully! ");
            alert.showAndWait();

        } else {
            alert.showAndWait();
        }

    }

    @FXML
    public void deleteAccount(ActionEvent event) throws IOException {

        UserDAOImpl userDAOImpl = new UserDAOImpl();

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setContentText("Are you sure you want to delete this account?");

        if (confirmationAlert.showAndWait().get() == ButtonType.OK) {
            System.out.println(user.getId());
          boolean isDeleted =  userDAOImpl.deleteById(user.getId());

            if(isDeleted){
            confirmationAlert.setAlertType(Alert.AlertType.INFORMATION);
            confirmationAlert.setContentText("Your account was successfully deleted! ");
            confirmationAlert.showAndWait();

                root = new FXMLLoader(getClass().getResource("/org/example/task_manager/sign-in.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root.load());
                stage.setScene(scene);
                stage.show();
            }



        }


    }

    @FXML
    public void goToTaskManager(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/task_manager/task-manager.fxml"));
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Platform.runLater(()->{   userNameLabel.setText(user.getUsername());
            emailLabel.setText(user.getEmail());});

    }
}
