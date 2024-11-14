package org.example.fit_plan.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.fit_plan.dao.implimentations.ExerciseDAOImpl;
import org.example.fit_plan.dao.implimentations.UserAccountDAOImpl;
import org.example.fit_plan.model.Exercise;
import org.example.fit_plan.model.UserAccount;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ExerciseDetailsProgressController implements Initializable{


        @FXML
        private ImageView backImage, homeView, workoutView, dietsView, dishView, progressView, settingsView, logOutView, exitImage, menuImage;

        @FXML
        private AnchorPane mainPane, buttonsPane, iconPane, toolPane,contentPane;

        @FXML
        private Label nameLabel,muscleCategoryLabel,setsRepsLabel,muscleCategoryL,setsL,descriptionL;

        @FXML
        private MediaView exerciseMedia;

        @FXML
        private ScrollPane pageScrollPane;

        @FXML
        private Text descriptionText;

        @FXML
        private Button deleteButton;

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

        UserAccountController controller = root.getController();
        controller.setUserId(userId);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void goToWorkout(ActionEvent event) throws IOException {
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
    public void goToDish(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-dish.fxml"));


        scene = new Scene(root.load());

        UserDishController controller = root.getController();
        controller.setUserId(userId);

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

        UserAccount userAccount = userAccountDAO.findById(userId);
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

        UserSettingsController controller = root.getController();

        UserAccount userAccount = userAccountDAO.findById(userId);
        controller.setUserAccount(userAccount);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToSignIn(ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/sign-in.fxml"));
        scene = new Scene(root.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    public void showDetails(Exercise exercise) {
            contentPane.getChildren().clear();


            Label titleLabel = new Label(exercise.getExerciseName());
            titleLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");
            AnchorPane.setLeftAnchor(titleLabel, 0.0);
            AnchorPane.setRightAnchor(titleLabel, 0.0);
            titleLabel.setAlignment(Pos.CENTER);



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


            AnchorPane.setLeftAnchor(exerciseMedia, 127.0);
            AnchorPane.setTopAnchor(exerciseMedia, 95.0);

            AnchorPane.setLeftAnchor(deleteButton, 280.0);
            AnchorPane.setTopAnchor(deleteButton, 500.0);



            muscleCategoryLabel.setText(exercise.getMuscleCategory());
            muscleCategoryLabel.setStyle("-fx-font-size: 14;");


            setsRepsLabel.setText(exercise.getSets());
            setsRepsLabel.setStyle("-fx-font-size: 14;");



            descriptionText.setText(exercise.getExerciseDescription());
            descriptionText.setStyle("-fx-font-size: 14;");
            TextFlow nutrientsFlow = new TextFlow(descriptionL);
            nutrientsFlow.setPrefWidth(400);



            VBox detailsBox = new VBox(10);
            detailsBox.getChildren().addAll(
                    muscleCategoryL,muscleCategoryLabel,
                    setsL, setsRepsLabel,
                    descriptionL, descriptionText
            );


            AnchorPane.setTopAnchor(detailsBox, 55.0);
            AnchorPane.setRightAnchor(detailsBox, 40.0);


            contentPane.getChildren().addAll(exerciseMedia, titleLabel, deleteButton,detailsBox);
        }


        @FXML
        public void deleteFromProgress(){

            UserAccountDAOImpl userAccountDAO = new UserAccountDAOImpl();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            boolean isDeleted = userAccountDAO.deleteExerciseById(exercise.getExerciseId());

            if(isDeleted){
                alert.setContentText("Exercise was deleted from favorites!");
                alert.showAndWait();
            } else {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Failed to delete the exercise from your favorites");
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



