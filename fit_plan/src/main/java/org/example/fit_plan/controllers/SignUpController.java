package org.example.fit_plan.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
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

public class SignUpController implements Initializable {
    @FXML
    private ImageView backImage, exitImage, menuImage;


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
    public void signUp(ActionEvent event) throws IOException {

        UserDAOImpl userDAOImpl = new UserDAOImpl();

        String email = emailField.getText();
        String login = usernameField.getText();
        String password = passwordField.getText();
        String repeatedPassword = repeatedPasswordField.getText();


        if(password.equals(repeatedPassword)) {

            User user = new User(email,login,password);
            userDAOImpl.create(user);

            root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-account.fxml"));
            scene = new Scene(root.load());

            UserAccountController controller = root.getController();
            controller.setUserId(user.getUserId());
            System.out.println(user.getUserId());
            controller.setUsername(user.getUsername());

            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }

    }

    @FXML
    private void goToSignIn(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/sign-in.fxml"));

        scene = new Scene(root.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image back = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\back.png");
        backImage.setImage(back);

        backImage.setOnMouseClicked(e -> {
            try {
                goToSignIn(new ActionEvent(backImage, backImage.getScene().getWindow()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Image exit = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\exit.png");
        exitImage.setImage(exit);
        exitImage.setOnMouseClicked(event -> System.exit(0));

    }
}
