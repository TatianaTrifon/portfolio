package org.example.fit_plan.controllers;

import com.jfoenix.controls.JFXToggleButton;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserExerciseController implements Initializable {

    @FXML
    private AnchorPane mainPane,buttonsPane,iconPane;

    @FXML
    private ScrollPane pageScrollPane;

    @FXML
    private Label pageNameLabel;

    @FXML
    private HBox exerciseContainer;

    @FXML
    private VBox scrollContent;

    @FXML
    private ImageView frontImage,backImage,homeView,workoutView,dietsView,dishView,progressView,settingsView,logOutView,exitImage,menuImage;

    @FXML
    private JFXToggleButton genderToggleButton;

    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    MuscleGroupMan muscleGroupMan;


    @FXML
    public void handleGenderToggle(){

        if(genderToggleButton.isSelected()){
            Image front = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\women_front.png");
            frontImage.setImage(front);

            Image back = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\women_back.png");
            backImage.setImage(back);
        } else {
            Image front = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\man_front.png");
            frontImage.setImage(front);

            Image back = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\man_back.png");
            backImage.setImage(back);

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

        Image diets = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\diets.png");
        dietsView.setImage(diets);

        Image workout = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\workoutPlan.png");
        workoutView.setImage(workout);

        Image dish = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\dishIdeas.png");
        dishView.setImage(dish);

        Image progress = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\progress.png");
        progressView.setImage(progress);

        Image settings = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\settings.png");
        settingsView.setImage(settings);

        Image logOut = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\logOut.png");
        logOutView.setImage(logOut);


        Image front = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\man_front.png");
        frontImage.setImage(front);

        Image back = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\man_back.png");
        backImage.setImage(back);

        MuscleGroupMan.trapsLeftFront.setOnMouseEntered(e -> {MuscleGroupMan.trapsLeftFront.setFill(Color.RED);
            MuscleGroupMan.trapsRightFront.setFill(Color.RED);

        });

        MuscleGroupMan.trapsRightFront.setOnMouseEntered(e -> {MuscleGroupMan.trapsLeftFront.setFill(Color.RED);
            MuscleGroupMan.trapsRightFront.setFill(Color.RED);

        });

mainPane.getChildren().addAll(MuscleGroupMan.trapsLeftFront,MuscleGroupMan.trapsRightFront);

        mainPane.setOnMouseClicked(event -> {
            System.out.println(event.getSceneX() + "," +  event.getSceneY());
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


    genderToggleButton.setText("Man");

        genderToggleButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                genderToggleButton.setText("Woman");
            } else {
                genderToggleButton.setText("Man");
            }
        });

    }




}
