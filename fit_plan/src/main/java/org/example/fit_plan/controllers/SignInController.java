package org.example.fit_plan.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.fit_plan.dao.implimentations.UserDAOImpl;
import org.example.fit_plan.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    private ImageView exitView;

    private FXMLLoader root;

    private Scene scene;

    private Stage stage;

    @FXML
    public void signIn(ActionEvent event) throws IOException {

        UserDAOImpl userDAOImpl = new UserDAOImpl();
        Alert alert = new Alert(Alert.AlertType.ERROR);


        String username = usernameField.getText();
        String password = passwordField.getText();

        User foundUser = userDAOImpl.findByName(username);
        if (username.equals("admin") && password.equals(foundUser.getPassword())) {

            root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/admin.fxml"));
            scene = new Scene(root.load());

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } else if (password.equals(foundUser.getPassword())) {

            root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-account.fxml"));
            scene = new Scene(root.load());

            UserAccountController controller = root.getController();
            controller.setUserId(foundUser.getUserId());
            controller.setUsername(foundUser.getUsername());

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.show();

        } else {
            alert.setContentText("Wrong username or password. Try again!");
            alert.showAndWait();
        }


    }

    @FXML
    public void goToSignUpPage(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/sign-up.fxml"));

        scene = new Scene(root.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image exit = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\exit.png");
        exitView.setImage(exit);

        exitView.setOnMouseClicked(event -> System.exit(0));
    }
}
