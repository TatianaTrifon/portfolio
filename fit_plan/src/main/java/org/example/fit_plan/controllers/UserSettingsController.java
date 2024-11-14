package org.example.fit_plan.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.fit_plan.dao.implimentations.UserAccountDAOImpl;
import org.example.fit_plan.dao.implimentations.UserDAOImpl;
import org.example.fit_plan.model.User;
import org.example.fit_plan.model.UserAccount;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserSettingsController implements Initializable {

    @FXML
    private ImageView  homeView, workoutView, dietsView, dishView, progressView, settingsView, logOutView, exitImage, menuImage, dishImageView;

    @FXML
    private AnchorPane mainPane, buttonsPane, iconPane, toolPane;

    @FXML
    private JFXButton homeButton,workoutButton,dietsButton,dishButton,progressButton,settingsButton,logOutButton;
    @FXML
    private ScrollPane pageScrollPane;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField oldPasswordField, newPasswordField;

    @FXML
    private Button updateEmailButton,updatePasswordButton,deleteButton;

    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    private UserAccount userAccount;

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;

        UserDAOImpl userDAO = new UserDAOImpl();

        User user = userDAO.findById(userAccount.getUserId());

        emailField.setText(user.getEmail());


    }


    @FXML
    public void goToHome(ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-account.fxml"));
        scene = new Scene(root.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void goToWorkout(ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-exercise.fxml"));
        scene = new Scene(root.load());

        UserExerciseController controller = root.getController();
        controller.setUserId(userAccount.getUserId());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToDiets(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-diet.fxml"));


        scene = new Scene(root.load());

        UserDietController controller = root.getController();
        controller.setUserId(userAccount.getUserId());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void goToDish(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-dish.fxml"));


        scene = new Scene(root.load());

        UserDishController controller = root.getController();
        controller.setUserId(userAccount.getUserId());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToProgress(ActionEvent event) throws IOException {

        UserAccountDAOImpl userAccountDAO = new UserAccountDAOImpl();

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-progress.fxml"));


        scene = new Scene(root.load());

        UserProgressController controller = root.getController();

        controller.setUserAccount(userAccount);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void goToSettings(ActionEvent event) throws IOException {
        UserAccountDAOImpl userAccountDAO = new UserAccountDAOImpl();

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-settings.fxml"));


        scene = new Scene(root.load());

        UserProgressController controller = root.getController();

        controller.setUserAccount(userAccount);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToSignIn() throws IOException {
        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/sign-in.fxml"));
        scene = new Scene(root.load());
        stage = (Stage) mainPane.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    public void updateUser(){

        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.findById(userAccount.getUserId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Alert alertError = new Alert(Alert.AlertType.ERROR);
        String email = emailField.getText();

        if((oldPasswordField.getText()).isEmpty()){


            user.setEmail(email);

            User updatedUser = userDAO.update(user);

            if(updatedUser != null){
                alert.setContentText("Account updated successfully!");
                alert.showAndWait();
            } else {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Failed to update the account!");
                alert.showAndWait();
            }
        } else if ((oldPasswordField.getText()).equals(user.getPassword())){

            String newPassword = newPasswordField.getText();

            user.setEmail(email);
            user.setPassword(newPassword);

            User updatedUser = userDAO.update(user);

            if(updatedUser != null){
                alert.setContentText("Account updated successfully!");
                alert.showAndWait();
                System.out.println(updatedUser.getPassword());
            } else {

                alertError.setContentText("Failed to update the account!");
                alertError.showAndWait();
            }

        } else {

            alertError.setContentText("The old password is wrong. Try again!");
            alertError.showAndWait();
        }



    }

    @FXML
    public void deleteAccount() throws IOException {

        UserDAOImpl userDAO = new UserDAOImpl();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setContentText("Are you sure you want to delete your account?");

        if(alert.showAndWait().get() == ButtonType.OK){
          boolean isDeleted =  userDAO.deleteById(userAccount.getUserId());

          if(isDeleted){
              alert.setAlertType(Alert.AlertType.INFORMATION);
              alert.setContentText("Your account was deleted successfully!");
              alert.showAndWait();

              goToSignIn();

          } else {
              alert.setAlertType(Alert.AlertType.ERROR);
              alert.setContentText("Failed to delete the account!");
              alert.showAndWait();
          }

        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pageScrollPane.setFitToWidth(true);
        pageScrollPane.setFitToHeight(true);


        Image exit = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\exit.png");
        exitImage.setImage(exit);

        Image menu = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\menu.png");
        menuImage.setImage(menu);

        Image home = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\home.png");
        homeView.setImage(home);
        homeView.setOnMouseClicked(event -> {
            try {
                goToHome(new ActionEvent(homeView, homeView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Image diets = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\diets.png");
        dietsView.setImage(diets);
        dietsView.setOnMouseClicked(event -> {
            try {
                goToDiets(new ActionEvent(dietsView, dietsView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Image workout = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\workoutPlan.png");
        workoutView.setImage(workout);
        workoutView.setOnMouseClicked(event -> {
            try {
                goToWorkout(new ActionEvent(workoutView, workoutView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Image dish = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\dishIdeas.png");
        dishView.setImage(dish);
        dishView.setOnMouseClicked(event -> {
            try {
                goToDish(new ActionEvent(dish, dishView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Image progress = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\progress.png");
        progressView.setImage(progress);
        progressView.setOnMouseClicked(event -> {
            try {
                goToProgress(new ActionEvent(progressView, progressView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Image settings = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\settings.png");
        settingsView.setImage(settings);
        settingsView.setOnMouseClicked(event -> {
            try {
                goToSettings(new ActionEvent(settingsView, settingsView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Image logOut = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\logOut.png");
        logOutView.setImage(logOut);
        logOutView.setOnMouseClicked(event -> {
            try {
                goToSignIn();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        buttonsPane.setTranslateX(-600);


        exitImage.setOnMouseClicked(event -> System.exit(0));

        menuImage.setOnMouseClicked(event -> {
            TranslateTransition paneTransition = new TranslateTransition(Duration.millis(500), buttonsPane);

            if (buttonsPane.getTranslateX() != 0) {
                paneTransition.setToX(0);
            } else {
                paneTransition.setToX(-600);
            }

            paneTransition.play();
        });

    }

}
