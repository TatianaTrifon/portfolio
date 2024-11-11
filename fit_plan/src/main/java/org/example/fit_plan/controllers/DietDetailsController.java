package org.example.fit_plan.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.fit_plan.dao.implimentations.ExerciseDAOImpl;
import org.example.fit_plan.dao.implimentations.UserAccountDAOImpl;
import org.example.fit_plan.model.Diet;
import org.example.fit_plan.model.UserAccount;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DietDetailsController implements Initializable {

    @FXML
    private ImageView  backImage, homeView, workoutView, dietsView, dishView, progressView, settingsView, logOutView, exitImage, menuImage,dietImageView;

    @FXML
    private AnchorPane mainPane, buttonsPane, iconPane, toolPane;

    @FXML
    private Text descriptionText;

    @FXML
    private Label nameLabel,dietCategoryLabel,allowedFoodLabel,forbiddenFoodLabel;

    @FXML
    private Button addButton;

    @FXML
    private JFXButton homeButton,workoutButton,dietsButton,dishButton,progressButton,settingsButton,logOutButton;

    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    private Diet diet;

    private Integer userId;

    private Stage previousStage;

    public void setPreviousStage(Stage previousStage) {
        this.previousStage = previousStage;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;

        nameLabel.setText(diet.getDietName());

        Image image = new Image(new ByteArrayInputStream(diet.getPicture()));
        dietImageView.setImage(image);

        dietCategoryLabel.setText(diet.getDietCategory());
        allowedFoodLabel.setText(diet.getAllowedFood());
        forbiddenFoodLabel.setText(diet.getForbiddenFood());
        descriptionText.setText(diet.getDietDescription());
    }


    public void goBack(ActionEvent event) {

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();


        if (previousStage != null) {
            previousStage.show();
        }
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
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToDiets(){}

    @FXML
    public void goToDish(){}

    @FXML
    public void goToProgress(){}

    @FXML
    public void goToSettings(){}

    @FXML
    public void goToSignIn(){}



    @FXML
    public void addToProgress(){

        UserAccountDAOImpl userAccountDAO = new UserAccountDAOImpl();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        boolean isAdded = userAccountDAO.addDietToUserById(diet.getDietId(),userId);

        if(isAdded){
            alert.setContentText("Diet was added to favorites!");
            alert.showAndWait();
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Failed to add the diet to your favorites");
            alert.showAndWait();
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image exit = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\exit.png");
        exitImage.setImage(exit);

        Image menu = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\menu.png");
        menuImage.setImage(menu);

        Image home = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\home.png");
        homeView.setImage(home);

        Image diets = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\diets.png");
        dietsView.setImage(diets);

        Image workout = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\workoutPlan.png");
        workoutView.setImage(workout);

        Image dish = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\dishIdeas.png");
        dishView.setImage(dish);

        Image progress = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\progress.png");
        progressView.setImage(progress);

        Image settings = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\settings.png");
        settingsView.setImage(settings);

        Image logOut = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\logOut.png");
        logOutView.setImage(logOut);

        Image back = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\back.png");
        backImage.setImage(back);

        backImage.setOnMouseClicked(e -> goBack(new ActionEvent(backImage, backImage.getScene().getWindow())));


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
