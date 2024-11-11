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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.fit_plan.dao.implimentations.ExerciseDAOImpl;
import org.example.fit_plan.model.Exercise;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ExerciseDetailsController implements Initializable {

    @FXML
    private ImageView backImage, homeView, workoutView, dietsView, dishView, progressView, settingsView, logOutView, exitImage, menuImage;

    @FXML
    private AnchorPane mainPane, buttonsPane, iconPane, toolPane;

    @FXML
    private Label nameLabel,muscleCategoryLabel,setsRepsLabel;

    @FXML
    private MediaView exerciseMedia;

    @FXML
    private Text descriptionText;

    @FXML
    private Button addButton;

    @FXML
    private JFXButton homeButton,workoutButton,dietsButton,dishButton,progressButton,settingsButton,logOutButton;

    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    private Exercise exercise;

    private Integer userId;

    private Stage previousStage;

    public void setPreviousStage(Stage previousStage) {
        this.previousStage = previousStage;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
        nameLabel.setText(exercise.getExerciseName());


        File tempFile = null;
        try {
            tempFile = File.createTempFile("exercise_video_", ".mp4");
            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(exercise.getVideo());
            }


        Media media = new Media(tempFile.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        exerciseMedia.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (tempFile != null) {
                tempFile.deleteOnExit();
            }
        }

        muscleCategoryLabel.setText(exercise.getMuscleCategory());
        setsRepsLabel.setText(exercise.getSets());
        descriptionText.setText(exercise.getExerciseDescription());

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
    public void goToDiets(ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-diet.fxml"));
        scene = new Scene(root.load());
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
    public void addToProgress(){

        ExerciseDAOImpl exerciseDAOImpl = new ExerciseDAOImpl();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        boolean isAdded = exerciseDAOImpl.addToProgress(userId,exercise.getExerciseId());

        if(isAdded){
            alert.setContentText("Exercise was added to favorites!");
            alert.showAndWait();
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Failed to add the exercise to your favorites");
            alert.showAndWait();
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
