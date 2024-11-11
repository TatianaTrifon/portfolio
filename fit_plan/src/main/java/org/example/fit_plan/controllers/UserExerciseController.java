package org.example.fit_plan.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.fit_plan.dao.implimentations.DietDAOImpl;
import org.example.fit_plan.dao.implimentations.ExerciseDAOImpl;
import org.example.fit_plan.model.Diet;
import org.example.fit_plan.model.Exercise;
import javafx.geometry.Insets;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public class UserExerciseController implements Initializable {

    @FXML
    private AnchorPane mainPane, buttonsPane, iconPane, toolPane, musclePane;

    @FXML
    private ScrollPane pageScrollPane;

    @FXML
    private Label pageNameLabel;

    @FXML
    private HBox exerciseContainer;

    @FXML
    private VBox exerciseContent;

    @FXML
    private ImageView frontImage, backImage, homeView, workoutView, dietsView, dishView, progressView, settingsView, logOutView, exitImage, menuImage;

    @FXML
    private JFXButton homeButton,workoutButton,dietsButton,dishButton,progressButton,settingsButton,logOutButton;

    @FXML
    private JFXToggleButton genderToggleButton;

    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    private Integer userId;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    @FXML
    public void goToHome(javafx.event.ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-account.fxml"));
        scene = new Scene(root.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void goToWorkout(javafx.event.ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-exercise.fxml"));
        scene = new Scene(root.load());

        UserExerciseController controller = root.getController();
        controller.setUserId(userId);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToDiets(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-diet.fxml"));
        scene = new Scene(root.load());

        UserDietController controller = root.getController();
        controller.setUserId(userId);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void goToDish(){}

    @FXML
    public void goToProgress(){}

    @FXML
    public void goToSettings(){}

    @FXML
    public void goToSignIn(){}





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

        musclePane.getChildren().removeAll(MuscleGroupWoman.getAllMusclesWomen());

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



        MuscleGroupMan.trapsLeftFront.setOnMouseClicked(e -> showExercises("trapsFront"));
        MuscleGroupMan.trapsRightFront.setOnMouseClicked(e -> showExercises("trapsFront"));
        MuscleGroupMan.chestFront.setOnMouseClicked(e -> showExercises("chest"));
        MuscleGroupMan.shoulderLeftFront.setOnMouseClicked(e -> showExercises("shouldersFront"));
        MuscleGroupMan.shoulderRightFront.setOnMouseClicked(e -> showExercises("shouldersFront"));
        MuscleGroupMan.abdominalsFront.setOnMouseClicked(e -> showExercises("abdominal"));
        MuscleGroupMan.obliqueLeftFront.setOnMouseClicked(e -> showExercises("oblique"));
        MuscleGroupMan.obliqueRightFront.setOnMouseClicked(e -> showExercises("oblique"));
        MuscleGroupMan.bicepsLeftFront.setOnMouseClicked(e -> showExercises("biceps"));
        MuscleGroupMan.bicepsRightFront.setOnMouseClicked(e -> showExercises("biceps"));
        MuscleGroupMan.forearmLeftFront.setOnMouseClicked(e -> showExercises("forearmFront"));
        MuscleGroupMan.forearmRightFront.setOnMouseClicked(e -> showExercises("forearmFront"));
        MuscleGroupMan.quadricepsLeftFront.setOnMouseClicked(e -> showExercises("quadriceps"));
        MuscleGroupMan.quadricepsRightFront.setOnMouseClicked(e -> showExercises("quadriceps"));
        MuscleGroupMan.calfLeftFront.setOnMouseClicked(e -> showExercises("calfFront"));
        MuscleGroupMan.calfRightFront.setOnMouseClicked(e -> showExercises("calfFront"));
        MuscleGroupMan.trapsUpBack.setOnMouseClicked(e -> showExercises("trapsUpBack"));
        MuscleGroupMan.trapsDownBack.setOnMouseClicked(e -> showExercises("trapsDownBack"));
        MuscleGroupMan.shoulderLeftBack.setOnMouseClicked(e -> showExercises("shoulderBack"));
        MuscleGroupMan.shoulderRightBack.setOnMouseClicked(e -> showExercises("shoulderBack"));
        MuscleGroupMan.latsLeftBack.setOnMouseClicked(e -> showExercises("lats"));
        MuscleGroupMan.latsRightBack.setOnMouseClicked(e -> showExercises("lats"));
        MuscleGroupMan.back.setOnMouseClicked(e -> showExercises("glutes"));
        MuscleGroupMan.glutes.setOnMouseClicked(e -> showExercises("back"));
        MuscleGroupMan.hamstringLeftBack.setOnMouseClicked(e -> showExercises("hamstring"));
        MuscleGroupMan.hamstringRightBack.setOnMouseClicked(e -> showExercises("hamstring"));
        MuscleGroupMan.calfLeftBack.setOnMouseClicked(e -> showExercises("calfBack"));
        MuscleGroupMan.calfRightBack.setOnMouseClicked(e -> showExercises("calfBack"));
        MuscleGroupMan.tricepLeftBack.setOnMouseClicked(e -> showExercises("triceps"));
        MuscleGroupMan.tricepRightBack.setOnMouseClicked(e -> showExercises("triceps"));
        MuscleGroupMan.forearmLeftBack.setOnMouseClicked(e -> showExercises("forearmBack"));
        MuscleGroupMan.forearmRightBack.setOnMouseClicked(e -> showExercises("forearmBack"));




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

       musclePane.getChildren().addAll(MuscleGroupMan.getAllMusclesMan());
    }


    public void showMuscleGroupWoman() {

        musclePane.getChildren().removeAll(MuscleGroupMan.getAllMusclesMan());


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


        MuscleGroupWoman.trapsLeftFront.setOnMouseClicked(e -> showExercises("trapsFront"));
        MuscleGroupWoman.trapsRightFront.setOnMouseClicked(e -> showExercises("trapsFront"));
        MuscleGroupWoman.chestFront.setOnMouseClicked(e -> showExercises("chest"));
        MuscleGroupWoman.shoulderLeftFront.setOnMouseClicked(e -> showExercises("shouldersFront"));
        MuscleGroupWoman.shouderRightFront.setOnMouseClicked(e -> showExercises("shouldersFront"));
        MuscleGroupWoman.abdominals.setOnMouseClicked(e -> showExercises("abdominal"));
        MuscleGroupWoman.obliquesLeftFront.setOnMouseClicked(e -> showExercises("oblique"));
        MuscleGroupWoman.obliquesRightFront.setOnMouseClicked(e -> showExercises("oblique"));
        MuscleGroupWoman.bicepsLeftFront.setOnMouseClicked(e -> showExercises("biceps"));
        MuscleGroupWoman.bicepsRightFront.setOnMouseClicked(e -> showExercises("biceps"));
        MuscleGroupWoman.forearmLeftFront.setOnMouseClicked(e -> showExercises("forearmFront"));
        MuscleGroupWoman.forearmRightFront.setOnMouseClicked(e -> showExercises("forearmFront"));
        MuscleGroupWoman.quadricepsLeftFront.setOnMouseClicked(e -> showExercises("quadriceps"));
        MuscleGroupWoman.quadricepsRightFront.setOnMouseClicked(e -> showExercises("quadriceps"));
        MuscleGroupWoman.calfLeftFront.setOnMouseClicked(e -> showExercises("calfFront"));
        MuscleGroupWoman.calfRightFront.setOnMouseClicked(e -> showExercises("calfFront"));
        MuscleGroupWoman.trapsUpBack.setOnMouseClicked(e -> showExercises("trapsUpBack"));
        MuscleGroupWoman.trapsDownBack.setOnMouseClicked(e -> showExercises("trapsDownBack"));
        MuscleGroupWoman.shoulderLeftBack.setOnMouseClicked(e -> showExercises("shoulderBack"));
        MuscleGroupWoman.shoulderRightBack.setOnMouseClicked(e -> showExercises("shoulderBack"));
        MuscleGroupWoman.latsLeftBack.setOnMouseClicked(e -> showExercises("lats"));
        MuscleGroupWoman.latsRightBack.setOnMouseClicked(e -> showExercises("lats"));
        MuscleGroupWoman.back.setOnMouseClicked(e -> showExercises("glutes"));
        MuscleGroupWoman.glutes.setOnMouseClicked(e -> showExercises("back"));
        MuscleGroupWoman.hamstringLeftBack.setOnMouseClicked(e -> showExercises("hamstring"));
        MuscleGroupWoman.hamstringRightBack.setOnMouseClicked(e -> showExercises("hamstring"));
        MuscleGroupWoman.calfLeftBack.setOnMouseClicked(e -> showExercises("calfBack"));
        MuscleGroupWoman.calfRightBack.setOnMouseClicked(e -> showExercises("calfBack"));
        MuscleGroupWoman.tricepsLeftBack.setOnMouseClicked(e -> showExercises("triceps"));
        MuscleGroupWoman.tricepsRightBack.setOnMouseClicked(e -> showExercises("triceps"));
        MuscleGroupWoman.forearmLeftBack.setOnMouseClicked(e -> showExercises("forearmBack"));
        MuscleGroupWoman.forearmRightBack.setOnMouseClicked(e -> showExercises("forearmBack"));


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

musclePane.getChildren().addAll(MuscleGroupWoman.getAllMusclesWomen());
    }

@FXML
    public void getCoordinates(){
    musclePane.setOnMouseClicked(event -> {
        double sceneX = event.getSceneX();
        double sceneY = event.getSceneY();

        double localX = musclePane.sceneToLocal(sceneX, sceneY).getX();
        double localY = musclePane.sceneToLocal(sceneX, sceneY).getY();

        System.out.println(String.format("%.2f, %.2f,", localX, localY));

    });

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


        genderToggleButton.setText("Male");

        genderToggleButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                genderToggleButton.setText("Female");
            } else {
                genderToggleButton.setText("Male");
            }
        });


        if (!genderToggleButton.isSelected()) {
            showMuscleGroupMan();
        } else {
            showMuscleGroupWoman();
        }

        genderToggleButton.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue) {
                exerciseContainer.getChildren().clear();
                showMuscleGroupWoman();
            } else {
                exerciseContainer.getChildren().clear();
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




    }

    public void goToExerciseDetails(Exercise exercise) {

        try {
            root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/exercise-details.fxml"));

            Stage currentStage = (Stage) mainPane.getScene().getWindow();

            Stage dietDetailsStage = new Stage();
            dietDetailsStage.setScene(new Scene(root.load()));

            ExerciseDetailsController controller = root.getController();
            controller.setExercise(exercise);
            controller.setUserId(userId);
            controller.setPreviousStage(currentStage);

            currentStage.hide();
            dietDetailsStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void showExercises(String muscleCategory) {
        ExerciseDAOImpl exerciseDAOImpl = new ExerciseDAOImpl();

        exerciseContainer.getChildren().clear();

        String gender = genderToggleButton.isSelected() ? "Female" : "Male";

        List<Exercise> exercises = exerciseDAOImpl.findByCategoryAndGender(muscleCategory, gender);

        exerciseContainer.setSpacing(20);

        for (Exercise exercise : exercises) {
            VBox exerciseBox = new VBox(10);
            exerciseBox.setStyle("-fx-border-color: #ccc; -fx-border-width: 1; -fx-padding: 10; -fx-background-color: #f9f9f9;");
            exerciseBox.setMaxHeight(302);
            exerciseBox.setMaxWidth(327);

            File tempFile = null;
            try {
                tempFile = File.createTempFile("exercise_video_", ".mp4");
                try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                    fos.write(exercise.getVideo());
                }
                Media media = new Media(tempFile.toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                MediaView mediaView = new MediaView(mediaPlayer);
                mediaView.setFitHeight(300);
                mediaView.setFitWidth(325);
                mediaPlayer.setAutoPlay(true);
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);



                exerciseBox.getChildren().add(mediaView);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (tempFile != null) {
                    tempFile.deleteOnExit();
                }
            }

            Label exerciseName = new Label(exercise.getExerciseName());
            exerciseName.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
            exerciseName.setWrapText(true);

            Label sets = new Label("Sets: " + exercise.getSets());
            sets.setStyle("-fx-font-size: 16;");
            sets.setWrapText(true);

            Label exerciseDescription = new Label(exercise.getExerciseDescription());
            exerciseDescription.setStyle("-fx-font-size: 14;");
            exerciseDescription.setWrapText(true);

            exerciseBox.getChildren().addAll(exerciseName, sets, exerciseDescription);

            exerciseBox.setOnMouseClicked(event -> goToExerciseDetails(exercise));


            VBox.setVgrow(exerciseName, Priority.ALWAYS);
            VBox.setVgrow(sets, Priority.ALWAYS);
            VBox.setVgrow(exerciseDescription, Priority.ALWAYS);


            VBox.setMargin(exerciseContainer, new Insets(50, 0, 0, 0));
            VBox.setMargin(exerciseBox, new Insets(50, 0, 0, 0));

            exerciseContainer.getChildren().add(exerciseBox);
        }

        exerciseContainer.setSpacing(22);
        exerciseContainer.setFillHeight(false);
    }



}
