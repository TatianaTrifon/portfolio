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
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.fit_plan.dao.implimentations.ExerciseDAOImpl;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserExerciseController implements Initializable {

    @FXML
    private AnchorPane mainPane, buttonsPane, iconPane, toolPane;

    @FXML
    private ScrollPane pageScrollPane;

    @FXML
    private Label pageNameLabel;

    @FXML
    private HBox exerciseContainer;

    @FXML
    private VBox scrollContent;

    @FXML
    private ImageView frontImage, backImage, homeView, workoutView, dietsView, dishView, progressView, settingsView, logOutView, exitImage, menuImage;

    @FXML
    private JFXToggleButton genderToggleButton;

    private FXMLLoader root;

    private Stage stage;

    private Scene scene;



    @FXML
    public void handleGenderToggle() {

        if (genderToggleButton.isSelected()) {
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


    public void showMuscleGroupMan() {

        mainPane.getChildren().removeAll(MuscleGroupWoman.getAllMusclesWomen());  // Remove man shapes if present

        MuscleGroupMan.trapsLeftFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.trapsRightFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.chestFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.shoulderLeftFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.shoulderRightFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.abdominalsFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.obliqueLeftFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.obliqueRightFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.bicepsLeftFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.bicepsRightFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.forearmLeftFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.forearmRightFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.quadricepsLeftFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.quadricepsRightFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.calfLeftFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.calfRightFront.setFill(Color.TRANSPARENT);
        MuscleGroupMan.trapsUpBack.setFill(Color.TRANSPARENT);
        MuscleGroupMan.trapsDownBack.setFill(Color.TRANSPARENT);
        MuscleGroupMan.shoulderLeftBack.setFill(Color.TRANSPARENT);
        MuscleGroupMan.shoulderRightBack.setFill(Color.TRANSPARENT);
        MuscleGroupMan.latsLeftBack.setFill(Color.TRANSPARENT);
        MuscleGroupMan.latsRightBack.setFill(Color.TRANSPARENT);
        MuscleGroupMan.back.setFill(Color.TRANSPARENT);
        MuscleGroupMan.glutes.setFill(Color.TRANSPARENT);
        MuscleGroupMan.hamstringLeftBack.setFill(Color.TRANSPARENT);
        MuscleGroupMan.hamstringRightBack.setFill(Color.TRANSPARENT);
        MuscleGroupMan.calfLeftBack.setFill(Color.TRANSPARENT);
        MuscleGroupMan.calfRightBack.setFill(Color.TRANSPARENT);
        MuscleGroupMan.tricepLeftBack.setFill(Color.TRANSPARENT);
        MuscleGroupMan.tricepRightBack.setFill(Color.TRANSPARENT);
        MuscleGroupMan.forearmLeftBack.setFill(Color.TRANSPARENT);
        MuscleGroupMan.forearmRightBack.setFill(Color.TRANSPARENT);


        MuscleGroupMan.trapsLeftFront.setOnMouseEntered(e -> {
            MuscleGroupMan.trapsLeftFront.setFill(Color.RED);
            MuscleGroupMan.trapsRightFront.setFill(Color.RED);
            MuscleGroupMan.trapsLeftFront.setOpacity(0.5);
            MuscleGroupMan.trapsRightFront.setOpacity(0.5);
        });

        MuscleGroupMan.trapsLeftFront.setOnMouseExited(e -> {
            MuscleGroupMan.trapsLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupMan.trapsRightFront.setFill(Color.TRANSPARENT);

        });

        MuscleGroupMan.trapsRightFront.setOnMouseEntered(e -> {
            MuscleGroupMan.trapsLeftFront.setFill(Color.RED);
            MuscleGroupMan.trapsRightFront.setFill(Color.RED);
            MuscleGroupMan.trapsLeftFront.setOpacity(0.5);
            MuscleGroupMan.trapsRightFront.setOpacity(0.5);
        });

        MuscleGroupMan.trapsRightFront.setOnMouseExited(e -> {
            MuscleGroupMan.trapsLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupMan.trapsRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.chestFront.setOnMouseEntered(e -> {
            MuscleGroupMan.chestFront.setFill(Color.RED);
            MuscleGroupMan.chestFront.setOpacity(0.5);
        });

        MuscleGroupMan.chestFront.setOnMouseExited(e -> {
            MuscleGroupMan.chestFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.shoulderLeftFront.setOnMouseEntered(e -> {
            MuscleGroupMan.shoulderLeftFront.setFill(Color.RED);
            MuscleGroupMan.shoulderRightFront.setFill(Color.RED);
            MuscleGroupMan.shoulderLeftFront.setOpacity(0.5);
            MuscleGroupMan.shoulderRightFront.setOpacity(0.5);
        });

        MuscleGroupMan.shoulderLeftFront.setOnMouseExited(e -> {
            MuscleGroupMan.shoulderLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupMan.shoulderRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.shoulderRightFront.setOnMouseEntered(e -> {
            MuscleGroupMan.shoulderLeftFront.setFill(Color.RED);
            MuscleGroupMan.shoulderRightFront.setFill(Color.RED);
            MuscleGroupMan.shoulderLeftFront.setOpacity(0.5);
            MuscleGroupMan.shoulderRightFront.setOpacity(0.5);
        });

        MuscleGroupMan.shoulderRightFront.setOnMouseExited(e -> {
            MuscleGroupMan.shoulderLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupMan.shoulderRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.abdominalsFront.setOnMouseEntered(e -> {
            MuscleGroupMan.abdominalsFront.setFill(Color.RED);
            MuscleGroupMan.abdominalsFront.setOpacity(0.5);
        });

        MuscleGroupMan.abdominalsFront.setOnMouseExited(e -> MuscleGroupMan.abdominalsFront.setFill(Color.TRANSPARENT));


        MuscleGroupMan.obliqueLeftFront.setOnMouseEntered(e -> {
            MuscleGroupMan.obliqueLeftFront.setFill(Color.RED);
            MuscleGroupMan.obliqueRightFront.setFill(Color.RED);
            MuscleGroupMan.obliqueLeftFront.setOpacity(0.5);
            MuscleGroupMan.obliqueRightFront.setOpacity(0.5);
        });

        MuscleGroupMan.obliqueLeftFront.setOnMouseExited(e -> {
            MuscleGroupMan.obliqueLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupMan.obliqueRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.obliqueRightFront.setOnMouseEntered(e -> {
            MuscleGroupMan.obliqueRightFront.setFill(Color.RED);
            MuscleGroupMan.obliqueLeftFront.setFill(Color.RED);
            MuscleGroupMan.obliqueLeftFront.setOpacity(0.5);
            MuscleGroupMan.obliqueRightFront.setOpacity(0.5);
        });

        MuscleGroupMan.obliqueRightFront.setOnMouseExited(e -> {
            MuscleGroupMan.obliqueLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupMan.obliqueRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.bicepsLeftFront.setOnMouseEntered(e -> {
            MuscleGroupMan.bicepsLeftFront.setFill(Color.RED);
            MuscleGroupMan.bicepsRightFront.setFill(Color.RED);
            MuscleGroupMan.bicepsLeftFront.setOpacity(0.5);
            MuscleGroupMan.bicepsRightFront.setOpacity(0.5);
        });

        MuscleGroupMan.bicepsLeftFront.setOnMouseExited(e -> {
            MuscleGroupMan.bicepsLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupMan.bicepsRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.bicepsRightFront.setOnMouseEntered(e -> {
            MuscleGroupMan.bicepsLeftFront.setFill(Color.RED);
            MuscleGroupMan.bicepsRightFront.setFill(Color.RED);
            MuscleGroupMan.bicepsLeftFront.setOpacity(0.5);
            MuscleGroupMan.bicepsRightFront.setOpacity(0.5);
        });

        MuscleGroupMan.bicepsRightFront.setOnMouseExited(e -> {
            MuscleGroupMan.bicepsLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupMan.bicepsRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.forearmLeftFront.setOnMouseEntered(e -> {
            MuscleGroupMan.forearmLeftFront.setFill(Color.RED);
            MuscleGroupMan.forearmRightFront.setFill(Color.RED);
            MuscleGroupMan.forearmLeftFront.setOpacity(0.5);
            MuscleGroupMan.forearmRightFront.setOpacity(0.5);
        });

        MuscleGroupMan.forearmLeftFront.setOnMouseExited(e -> {
            MuscleGroupMan.forearmLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupMan.forearmRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.forearmRightFront.setOnMouseEntered(e -> {
            MuscleGroupMan.forearmLeftFront.setFill(Color.RED);
            MuscleGroupMan.forearmRightFront.setFill(Color.RED);
            MuscleGroupMan.forearmLeftFront.setOpacity(0.5);
            MuscleGroupMan.forearmRightFront.setOpacity(0.5);
        });

        MuscleGroupMan.forearmRightFront.setOnMouseExited(e -> {
            MuscleGroupMan.forearmLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupMan.forearmRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.quadricepsLeftFront.setOnMouseEntered(e -> {
            MuscleGroupMan.quadricepsLeftFront.setFill(Color.RED);
            MuscleGroupMan.quadricepsRightFront.setFill(Color.RED);
            MuscleGroupMan.quadricepsLeftFront.setOpacity(0.5);
            MuscleGroupMan.quadricepsRightFront.setOpacity(0.5);
        });

        MuscleGroupMan.quadricepsLeftFront.setOnMouseExited(e -> {
            MuscleGroupMan.quadricepsLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupMan.quadricepsRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.quadricepsRightFront.setOnMouseEntered(e -> {
            MuscleGroupMan.quadricepsLeftFront.setFill(Color.RED);
            MuscleGroupMan.quadricepsRightFront.setFill(Color.RED);
            MuscleGroupMan.quadricepsLeftFront.setOpacity(0.5);
            MuscleGroupMan.quadricepsRightFront.setOpacity(0.5);
        });

        MuscleGroupMan.quadricepsRightFront.setOnMouseExited(e -> {
            MuscleGroupMan.quadricepsLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupMan.quadricepsRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.calfLeftFront.setOnMouseEntered(e -> {
            MuscleGroupMan.calfLeftFront.setFill(Color.RED);
            MuscleGroupMan.calfRightFront.setFill(Color.RED);
            MuscleGroupMan.calfLeftFront.setOpacity(0.5);
            MuscleGroupMan.calfRightFront.setOpacity(0.5);
        });

        MuscleGroupMan.calfLeftFront.setOnMouseExited(e -> {
            MuscleGroupMan.calfLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupMan.calfRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.calfRightFront.setOnMouseEntered(e -> {
            MuscleGroupMan.calfLeftFront.setFill(Color.RED);
            MuscleGroupMan.calfRightFront.setFill(Color.RED);
            MuscleGroupMan.calfLeftFront.setOpacity(0.5);
            MuscleGroupMan.calfRightFront.setOpacity(0.5);
        });

        MuscleGroupMan.calfRightFront.setOnMouseExited(e -> {
            MuscleGroupMan.calfLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupMan.calfRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.trapsUpBack.setOnMouseEntered(e -> {
            MuscleGroupMan.trapsUpBack.setFill(Color.RED);
            MuscleGroupMan.trapsUpBack.setOpacity(0.5);
        });

        MuscleGroupMan.trapsUpBack.setOnMouseExited(e -> MuscleGroupMan.trapsUpBack.setFill(Color.TRANSPARENT));

        MuscleGroupMan.trapsDownBack.setOnMouseEntered(e -> {
            MuscleGroupMan.trapsDownBack.setFill(Color.RED);
            MuscleGroupMan.trapsDownBack.setOpacity(0.5);
        });
        MuscleGroupMan.trapsDownBack.setOnMouseExited(e -> MuscleGroupMan.trapsDownBack.setFill(Color.TRANSPARENT));


        MuscleGroupMan.shoulderLeftBack.setOnMouseEntered(e -> {
            MuscleGroupMan.shoulderLeftBack.setFill(Color.RED);
            MuscleGroupMan.shoulderRightBack.setFill(Color.RED);
            MuscleGroupMan.shoulderLeftBack.setOpacity(0.5);
            MuscleGroupMan.shoulderRightBack.setOpacity(0.5);
        });

        MuscleGroupMan.shoulderLeftBack.setOnMouseExited(e -> {
            MuscleGroupMan.shoulderLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupMan.shoulderRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.shoulderRightBack.setOnMouseEntered(e -> {
            MuscleGroupMan.shoulderLeftBack.setFill(Color.RED);
            MuscleGroupMan.shoulderRightBack.setFill(Color.RED);
            MuscleGroupMan.shoulderLeftBack.setOpacity(0.5);
            MuscleGroupMan.shoulderRightBack.setOpacity(0.5);
        });

        MuscleGroupMan.shoulderRightBack.setOnMouseExited(e -> {
            MuscleGroupMan.shoulderLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupMan.shoulderRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.latsLeftBack.setOnMouseEntered(e -> {
            MuscleGroupMan.latsLeftBack.setFill(Color.RED);
            MuscleGroupMan.latsRightBack.setFill(Color.RED);
            MuscleGroupMan.latsLeftBack.setOpacity(0.5);
            MuscleGroupMan.latsRightBack.setOpacity(0.5);
        });

        MuscleGroupMan.latsLeftBack.setOnMouseExited(e -> {
            MuscleGroupMan.latsLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupMan.latsRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.latsRightBack.setOnMouseEntered(e -> {
            MuscleGroupMan.latsLeftBack.setFill(Color.RED);
            MuscleGroupMan.latsRightBack.setFill(Color.RED);
            MuscleGroupMan.latsLeftBack.setOpacity(0.5);
            MuscleGroupMan.latsRightBack.setOpacity(0.5);
        });

        MuscleGroupMan.latsRightBack.setOnMouseExited(e -> {
            MuscleGroupMan.latsLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupMan.latsRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.back.setOnMouseEntered(e -> {
            MuscleGroupMan.back.setFill(Color.RED);
            MuscleGroupMan.back.setOpacity(0.5);
        });
        MuscleGroupMan.back.setOnMouseExited(e -> MuscleGroupMan.back.setFill(Color.TRANSPARENT));


        MuscleGroupMan.glutes.setOnMouseEntered(e -> {
            MuscleGroupMan.glutes.setFill(Color.RED);
            MuscleGroupMan.glutes.setOpacity(0.5);
        });
        MuscleGroupMan.glutes.setOnMouseExited(e -> MuscleGroupMan.glutes.setFill(Color.TRANSPARENT));


        MuscleGroupMan.hamstringLeftBack.setOnMouseEntered(e -> {
            MuscleGroupMan.hamstringLeftBack.setFill(Color.RED);
            MuscleGroupMan.hamstringRightBack.setFill(Color.RED);
            MuscleGroupMan.hamstringLeftBack.setOpacity(0.5);
            MuscleGroupMan.hamstringRightBack.setOpacity(0.5);
        });

        MuscleGroupMan.hamstringLeftBack.setOnMouseExited(e -> {
            MuscleGroupMan.hamstringLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupMan.hamstringRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.hamstringRightBack.setOnMouseEntered(e -> {
            MuscleGroupMan.hamstringLeftBack.setFill(Color.RED);
            MuscleGroupMan.hamstringRightBack.setFill(Color.RED);
            MuscleGroupMan.hamstringLeftBack.setOpacity(0.5);
            MuscleGroupMan.hamstringRightBack.setOpacity(0.5);
        });

        MuscleGroupMan.hamstringRightBack.setOnMouseExited(e -> {
            MuscleGroupMan.hamstringLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupMan.hamstringRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.calfLeftBack.setOnMouseEntered(e -> {
            MuscleGroupMan.calfLeftBack.setFill(Color.RED);
            MuscleGroupMan.calfRightBack.setFill(Color.RED);
            MuscleGroupMan.calfLeftBack.setOpacity(0.5);
            MuscleGroupMan.calfRightBack.setOpacity(0.5);
        });

        MuscleGroupMan.calfLeftBack.setOnMouseExited(e -> {
            MuscleGroupMan.calfLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupMan.calfRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.calfRightBack.setOnMouseEntered(e -> {
            MuscleGroupMan.calfLeftBack.setFill(Color.RED);
            MuscleGroupMan.calfRightBack.setFill(Color.RED);
            MuscleGroupMan.calfLeftBack.setOpacity(0.5);
            MuscleGroupMan.calfRightBack.setOpacity(0.5);
        });

        MuscleGroupMan.calfRightBack.setOnMouseExited(e -> {
            MuscleGroupMan.calfLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupMan.calfRightBack.setFill(Color.TRANSPARENT);
        });


        MuscleGroupMan.tricepLeftBack.setOnMouseEntered(e -> {
            MuscleGroupMan.tricepLeftBack.setFill(Color.RED);
            MuscleGroupMan.tricepRightBack.setFill(Color.RED);
            MuscleGroupMan.tricepLeftBack.setOpacity(0.5);
            MuscleGroupMan.tricepRightBack.setOpacity(0.5);
        });

        MuscleGroupMan.tricepLeftBack.setOnMouseExited(e -> {
            MuscleGroupMan.tricepLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupMan.tricepRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.tricepRightBack.setOnMouseEntered(e -> {
            MuscleGroupMan.tricepLeftBack.setFill(Color.RED);
            MuscleGroupMan.tricepRightBack.setFill(Color.RED);
            MuscleGroupMan.tricepLeftBack.setOpacity(0.5);
            MuscleGroupMan.tricepRightBack.setOpacity(0.5);
        });

        MuscleGroupMan.tricepRightBack.setOnMouseExited(e -> {
            MuscleGroupMan.tricepLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupMan.tricepRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.forearmLeftBack.setOnMouseEntered(e -> {
            MuscleGroupMan.forearmLeftBack.setFill(Color.RED);
            MuscleGroupMan.forearmRightBack.setFill(Color.RED);
            MuscleGroupMan.forearmLeftBack.setOpacity(0.5);
            MuscleGroupMan.forearmRightBack.setOpacity(0.5);
        });

        MuscleGroupMan.forearmLeftBack.setOnMouseExited(e -> {
            MuscleGroupMan.forearmLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupMan.forearmRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupMan.forearmRightBack.setOnMouseEntered(e -> {
            MuscleGroupMan.forearmLeftBack.setFill(Color.RED);
            MuscleGroupMan.forearmRightBack.setFill(Color.RED);
            MuscleGroupMan.forearmLeftBack.setOpacity(0.5);
            MuscleGroupMan.forearmRightBack.setOpacity(0.5);
        });

        MuscleGroupMan.forearmRightBack.setOnMouseExited(e -> {
            MuscleGroupMan.forearmLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupMan.forearmRightBack.setFill(Color.TRANSPARENT);
        });

       mainPane.getChildren().addAll(MuscleGroupMan.getAllMusclesMan());
    }


    public void showMuscleGroupWoman() {

        mainPane.getChildren().removeAll(MuscleGroupMan.getAllMusclesMan());


        MuscleGroupWoman.trapsLeftFront.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.trapsRightFront.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.chestFront.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.shoulderLeftFront.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.shouderRightFront.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.abdominals.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.obliquesLeftFront.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.obliquesRightFront.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.bicepsLeftFront.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.bicepsRightFront.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.forearmLeftFront.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.forearmRightFront.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.quadricepsLeftFront.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.quadricepsRightFront.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.calfLeftFront.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.calfRightFront.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.trapsUpBack.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.trapsDownBack.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.shoulderLeftBack.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.shoulderRightBack.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.latsLeftBack.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.latsRightBack.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.back.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.glutes.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.hamstringLeftBack.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.hamstringRightBack.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.calfLeftBack.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.calfRightBack.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.tricepsLeftBack.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.tricepsRightBack.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.forearmLeftBack.setFill(Color.TRANSPARENT);
        MuscleGroupWoman.forearmRightBack.setFill(Color.TRANSPARENT);


        MuscleGroupWoman.trapsLeftFront.setOnMouseEntered(e -> {
            MuscleGroupWoman.trapsLeftFront.setFill(Color.RED);
            MuscleGroupWoman.trapsRightFront.setFill(Color.RED);
            MuscleGroupWoman.trapsLeftFront.setOpacity(0.5);
            MuscleGroupWoman.trapsRightFront.setOpacity(0.5);
        });

        MuscleGroupWoman.trapsLeftFront.setOnMouseExited(e -> {
            MuscleGroupWoman.trapsLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.trapsRightFront.setFill(Color.TRANSPARENT);

        });

        MuscleGroupWoman.trapsRightFront.setOnMouseEntered(e -> {
            MuscleGroupWoman.trapsLeftFront.setFill(Color.RED);
            MuscleGroupWoman.trapsRightFront.setFill(Color.RED);
            MuscleGroupWoman.trapsLeftFront.setOpacity(0.5);
            MuscleGroupWoman.trapsRightFront.setOpacity(0.5);
        });

        MuscleGroupWoman.trapsRightFront.setOnMouseExited(e -> {
            MuscleGroupWoman.trapsLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.trapsRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.chestFront.setOnMouseEntered(e -> {
            MuscleGroupWoman.chestFront.setFill(Color.RED);
            MuscleGroupWoman.chestFront.setOpacity(0.5);
        });

        MuscleGroupWoman.chestFront.setOnMouseExited(e -> MuscleGroupWoman.chestFront.setFill(Color.TRANSPARENT));

        MuscleGroupWoman.shoulderLeftFront.setOnMouseEntered(e -> {
            MuscleGroupWoman.shoulderLeftFront.setFill(Color.RED);
            MuscleGroupWoman.shouderRightFront.setFill(Color.RED);
            MuscleGroupWoman.shoulderLeftFront.setOpacity(0.5);
            MuscleGroupWoman.shouderRightFront.setOpacity(0.5);
        });

        MuscleGroupWoman.shoulderLeftFront.setOnMouseExited(e -> {
            MuscleGroupWoman.shoulderLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.shouderRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.shouderRightFront.setOnMouseEntered(e -> {
            MuscleGroupWoman.shoulderLeftFront.setFill(Color.RED);
            MuscleGroupWoman.shouderRightFront.setFill(Color.RED);
            MuscleGroupWoman.shoulderLeftFront.setOpacity(0.5);
            MuscleGroupWoman.shouderRightFront.setOpacity(0.5);
        });

        MuscleGroupWoman.shouderRightFront.setOnMouseExited(e -> {
            MuscleGroupWoman.shoulderLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.shouderRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.abdominals.setOnMouseEntered(e -> {
            MuscleGroupWoman.abdominals.setFill(Color.RED);
            MuscleGroupWoman.abdominals.setOpacity(0.5);
        });

        MuscleGroupWoman.abdominals.setOnMouseExited(e -> MuscleGroupWoman.abdominals.setFill(Color.TRANSPARENT));


        MuscleGroupWoman.obliquesLeftFront.setOnMouseEntered(e -> {
            MuscleGroupWoman.obliquesLeftFront.setFill(Color.RED);
            MuscleGroupWoman.obliquesRightFront.setFill(Color.RED);
            MuscleGroupWoman.obliquesLeftFront.setOpacity(0.5);
            MuscleGroupWoman.obliquesRightFront.setOpacity(0.5);
        });

        MuscleGroupWoman.obliquesLeftFront.setOnMouseExited(e -> {
            MuscleGroupWoman.obliquesLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.obliquesRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.obliquesRightFront.setOnMouseEntered(e -> {
            MuscleGroupWoman.obliquesLeftFront.setFill(Color.RED);
            MuscleGroupWoman.obliquesRightFront.setFill(Color.RED);
            MuscleGroupWoman.obliquesLeftFront.setOpacity(0.5);
            MuscleGroupWoman.obliquesRightFront.setOpacity(0.5);
        });

        MuscleGroupWoman.obliquesRightFront.setOnMouseExited(e -> {
            MuscleGroupWoman.obliquesLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.obliquesRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.bicepsLeftFront.setOnMouseEntered(e -> {
            MuscleGroupWoman.bicepsLeftFront.setFill(Color.RED);
            MuscleGroupWoman.bicepsRightFront.setFill(Color.RED);
            MuscleGroupWoman.bicepsLeftFront.setOpacity(0.5);
            MuscleGroupWoman.bicepsRightFront.setOpacity(0.5);
        });

        MuscleGroupWoman.bicepsLeftFront.setOnMouseExited(e -> {
            MuscleGroupWoman.bicepsLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.bicepsRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.bicepsRightFront.setOnMouseEntered(e -> {
            MuscleGroupWoman.bicepsLeftFront.setFill(Color.RED);
            MuscleGroupWoman.bicepsRightFront.setFill(Color.RED);
            MuscleGroupWoman.bicepsLeftFront.setOpacity(0.5);
            MuscleGroupWoman.bicepsRightFront.setOpacity(0.5);
        });

        MuscleGroupWoman.bicepsRightFront.setOnMouseExited(e -> {
            MuscleGroupWoman.bicepsLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.bicepsRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.forearmLeftFront.setOnMouseEntered(e -> {
            MuscleGroupWoman.forearmLeftFront.setFill(Color.RED);
            MuscleGroupWoman.forearmRightFront.setFill(Color.RED);
            MuscleGroupWoman.forearmLeftFront.setOpacity(0.5);
            MuscleGroupWoman.forearmRightFront.setOpacity(0.5);
        });

        MuscleGroupWoman.forearmLeftFront.setOnMouseExited(e -> {
            MuscleGroupWoman.forearmLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.forearmRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.forearmRightFront.setOnMouseEntered(e -> {
            MuscleGroupWoman.forearmLeftFront.setFill(Color.RED);
            MuscleGroupWoman.forearmRightFront.setFill(Color.RED);
            MuscleGroupWoman.forearmLeftFront.setOpacity(0.5);
            MuscleGroupWoman.forearmRightFront.setOpacity(0.5);
        });

        MuscleGroupWoman.forearmRightFront.setOnMouseExited(e -> {
            MuscleGroupWoman.forearmLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.forearmRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.quadricepsLeftFront.setOnMouseEntered(e -> {
            MuscleGroupWoman.quadricepsLeftFront.setFill(Color.RED);
            MuscleGroupWoman.quadricepsRightFront.setFill(Color.RED);
            MuscleGroupWoman.quadricepsLeftFront.setOpacity(0.5);
            MuscleGroupWoman.quadricepsRightFront.setOpacity(0.5);
        });

        MuscleGroupWoman.quadricepsLeftFront.setOnMouseExited(e -> {
            MuscleGroupWoman.quadricepsLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.quadricepsRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.quadricepsRightFront.setOnMouseEntered(e -> {
            MuscleGroupWoman.quadricepsLeftFront.setFill(Color.RED);
            MuscleGroupWoman.quadricepsRightFront.setFill(Color.RED);
            MuscleGroupWoman.quadricepsLeftFront.setOpacity(0.5);
            MuscleGroupWoman.quadricepsRightFront.setOpacity(0.5);
        });

        MuscleGroupWoman.quadricepsRightFront.setOnMouseExited(e -> {
            MuscleGroupWoman.quadricepsLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.quadricepsRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.calfLeftFront.setOnMouseEntered(e -> {
            MuscleGroupWoman.calfLeftFront.setFill(Color.RED);
            MuscleGroupWoman.calfRightFront.setFill(Color.RED);
            MuscleGroupWoman.calfLeftFront.setOpacity(0.5);
            MuscleGroupWoman.calfRightFront.setOpacity(0.5);
        });

        MuscleGroupWoman.calfLeftFront.setOnMouseExited(e -> {
            MuscleGroupWoman.calfLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.calfRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.calfRightFront.setOnMouseEntered(e -> {
            MuscleGroupWoman.calfLeftFront.setFill(Color.RED);
            MuscleGroupWoman.calfRightFront.setFill(Color.RED);
            MuscleGroupWoman.calfLeftFront.setOpacity(0.5);
            MuscleGroupWoman.calfRightFront.setOpacity(0.5);
        });

        MuscleGroupWoman.calfRightFront.setOnMouseExited(e -> {
            MuscleGroupWoman.calfLeftFront.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.calfRightFront.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.trapsUpBack.setOnMouseEntered(e -> {
            MuscleGroupWoman.trapsUpBack.setFill(Color.RED);
            MuscleGroupWoman.trapsUpBack.setOpacity(0.5);
        });

        MuscleGroupWoman.trapsUpBack.setOnMouseExited(e -> MuscleGroupWoman.trapsUpBack.setFill(Color.TRANSPARENT));

        MuscleGroupWoman.trapsDownBack.setOnMouseEntered(e -> {
            MuscleGroupWoman.trapsDownBack.setFill(Color.RED);
            MuscleGroupWoman.trapsDownBack.setOpacity(0.5);
        });
        MuscleGroupWoman.trapsDownBack.setOnMouseExited(e -> MuscleGroupWoman.trapsDownBack.setFill(Color.TRANSPARENT));


        MuscleGroupWoman.shoulderLeftBack.setOnMouseEntered(e -> {
            MuscleGroupWoman.shoulderLeftBack.setFill(Color.RED);
            MuscleGroupWoman.shoulderRightBack.setFill(Color.RED);
            MuscleGroupWoman.shoulderLeftBack.setOpacity(0.5);
            MuscleGroupWoman.shoulderRightBack.setOpacity(0.5);
        });

        MuscleGroupWoman.shoulderLeftBack.setOnMouseExited(e -> {
            MuscleGroupWoman.shoulderLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.shoulderRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.shoulderRightBack.setOnMouseEntered(e -> {
            MuscleGroupWoman.shoulderLeftBack.setFill(Color.RED);
            MuscleGroupWoman.shoulderRightBack.setFill(Color.RED);
            MuscleGroupWoman.shoulderLeftBack.setOpacity(0.5);
            MuscleGroupWoman.shoulderRightBack.setOpacity(0.5);
        });

        MuscleGroupWoman.shoulderRightBack.setOnMouseExited(e -> {
            MuscleGroupWoman.shoulderLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.shoulderRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.latsLeftBack.setOnMouseEntered(e -> {
            MuscleGroupWoman.latsLeftBack.setFill(Color.RED);
            MuscleGroupWoman.latsRightBack.setFill(Color.RED);
            MuscleGroupWoman.latsLeftBack.setOpacity(0.5);
            MuscleGroupWoman.latsRightBack.setOpacity(0.5);
        });

        MuscleGroupWoman.latsLeftBack.setOnMouseExited(e -> {
            MuscleGroupWoman.latsLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.latsRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.latsRightBack.setOnMouseEntered(e -> {
            MuscleGroupWoman.latsLeftBack.setFill(Color.RED);
            MuscleGroupWoman.latsRightBack.setFill(Color.RED);
            MuscleGroupWoman.latsLeftBack.setOpacity(0.5);
            MuscleGroupWoman.latsRightBack.setOpacity(0.5);
        });

        MuscleGroupWoman.latsRightBack.setOnMouseExited(e -> {
            MuscleGroupWoman.latsLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.latsRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.back.setOnMouseEntered(e -> {
            MuscleGroupWoman.back.setFill(Color.RED);
            MuscleGroupWoman.back.setOpacity(0.5);
        });
        MuscleGroupWoman.back.setOnMouseExited(e -> MuscleGroupWoman.back.setFill(Color.TRANSPARENT));


        MuscleGroupWoman.glutes.setOnMouseEntered(e -> {
            MuscleGroupWoman.glutes.setFill(Color.RED);
            MuscleGroupWoman.glutes.setOpacity(0.5);
        });
        MuscleGroupWoman.glutes.setOnMouseExited(e -> MuscleGroupWoman.glutes.setFill(Color.TRANSPARENT));


        MuscleGroupWoman.hamstringLeftBack.setOnMouseEntered(e -> {
            MuscleGroupWoman.hamstringLeftBack.setFill(Color.RED);
            MuscleGroupWoman.hamstringRightBack.setFill(Color.RED);
            MuscleGroupWoman.hamstringLeftBack.setOpacity(0.5);
            MuscleGroupWoman.hamstringRightBack.setOpacity(0.5);
        });

        MuscleGroupWoman.hamstringLeftBack.setOnMouseExited(e -> {
            MuscleGroupWoman.hamstringLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.hamstringRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.hamstringRightBack.setOnMouseEntered(e -> {
            MuscleGroupWoman.hamstringLeftBack.setFill(Color.RED);
            MuscleGroupWoman.hamstringRightBack.setFill(Color.RED);
            MuscleGroupWoman.hamstringLeftBack.setOpacity(0.5);
            MuscleGroupWoman.hamstringRightBack.setOpacity(0.5);
        });

        MuscleGroupWoman.hamstringRightBack.setOnMouseExited(e -> {
            MuscleGroupWoman.hamstringLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.hamstringRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.calfLeftBack.setOnMouseEntered(e -> {
            MuscleGroupWoman.calfLeftBack.setFill(Color.RED);
            MuscleGroupWoman.calfRightBack.setFill(Color.RED);
            MuscleGroupWoman.calfLeftBack.setOpacity(0.5);
            MuscleGroupWoman.calfRightBack.setOpacity(0.5);
        });

        MuscleGroupWoman.calfLeftBack.setOnMouseExited(e -> {
            MuscleGroupWoman.calfLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.calfRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.calfRightBack.setOnMouseEntered(e -> {
            MuscleGroupWoman.calfLeftBack.setFill(Color.RED);
            MuscleGroupWoman.calfRightBack.setFill(Color.RED);
            MuscleGroupWoman.calfLeftBack.setOpacity(0.5);
            MuscleGroupWoman.calfRightBack.setOpacity(0.5);
        });

        MuscleGroupWoman.calfRightBack.setOnMouseExited(e -> {
            MuscleGroupWoman.calfLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.calfRightBack.setFill(Color.TRANSPARENT);
        });


        MuscleGroupWoman.tricepsLeftBack.setOnMouseEntered(e -> {
            MuscleGroupWoman.tricepsLeftBack.setFill(Color.RED);
            MuscleGroupWoman.tricepsRightBack.setFill(Color.RED);
            MuscleGroupWoman.tricepsLeftBack.setOpacity(0.5);
            MuscleGroupWoman.tricepsRightBack.setOpacity(0.5);
        });

        MuscleGroupWoman.tricepsLeftBack.setOnMouseExited(e -> {
            MuscleGroupWoman.tricepsLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.tricepsRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.tricepsRightBack.setOnMouseEntered(e -> {
            MuscleGroupWoman.tricepsLeftBack.setFill(Color.RED);
            MuscleGroupWoman.tricepsRightBack.setFill(Color.RED);
            MuscleGroupWoman.tricepsLeftBack.setOpacity(0.5);
            MuscleGroupWoman.tricepsRightBack.setOpacity(0.5);
        });

        MuscleGroupWoman.tricepsRightBack.setOnMouseExited(e -> {
            MuscleGroupWoman.tricepsLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.tricepsRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.forearmLeftBack.setOnMouseEntered(e -> {
            MuscleGroupWoman.forearmLeftBack.setFill(Color.RED);
            MuscleGroupWoman.forearmRightBack.setFill(Color.RED);
            MuscleGroupWoman.forearmLeftBack.setOpacity(0.5);
            MuscleGroupWoman.forearmRightBack.setOpacity(0.5);
        });

        MuscleGroupWoman.forearmLeftBack.setOnMouseExited(e -> {
            MuscleGroupWoman.forearmLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.forearmRightBack.setFill(Color.TRANSPARENT);
        });

        MuscleGroupWoman.forearmRightBack.setOnMouseEntered(e -> {
            MuscleGroupWoman.forearmLeftBack.setFill(Color.RED);
            MuscleGroupWoman.forearmRightBack.setFill(Color.RED);
            MuscleGroupWoman.forearmLeftBack.setOpacity(0.5);
            MuscleGroupWoman.forearmRightBack.setOpacity(0.5);
        });

        MuscleGroupWoman.forearmRightBack.setOnMouseExited(e -> {
            MuscleGroupWoman.forearmLeftBack.setFill(Color.TRANSPARENT);
            MuscleGroupWoman.forearmRightBack.setFill(Color.TRANSPARENT);
        });

mainPane.getChildren().addAll(MuscleGroupWoman.getAllMusclesWomen());
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


        mainPane.setOnMouseClicked(event -> {
            System.out.println(event.getSceneX() + "," + event.getSceneY() + ",");
        });


        if (!genderToggleButton.isSelected()) {

            showMuscleGroupMan();
        } else {

            showMuscleGroupWoman();
        }

        genderToggleButton.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue) {

                showMuscleGroupWoman();
            } else {

                showMuscleGroupMan();
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


List<Polygon> musclesMan = MuscleGroupMan.getAllMusclesMan();
MuscleGroupMan.setMuscleGroupId();
MuscleGroupWoman.setMuscleGroupId();

        ExerciseDAOImpl exerciseDAOImpl = new ExerciseDAOImpl();

for(Polygon group : musclesMan){
    group.setOnMouseClicked(e -> exerciseDAOImpl.findByCategory(group.getId()));
}




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
