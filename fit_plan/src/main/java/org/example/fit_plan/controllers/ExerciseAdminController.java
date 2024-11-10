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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.fit_plan.dao.implimentations.ExerciseDAOImpl;
import org.example.fit_plan.model.Exercise;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExerciseAdminController implements Initializable {


    @FXML
    private AnchorPane mainPane, iconPane, buttonsPane, exerciseManagePane;

    @FXML
    private ImageView menuView, exitView, homeView, dietsView, dishesView, exerciseView, logOutView;

    @FXML
    private JFXButton homeButton, dietsButton, dishesButton, exerciseButton, logOutButton;

    @FXML
    private Label idLabel, pictureLabel, nameLabel, descriptionLabel, categoryLabel, SetsRepsLabel, genderLabel;

    @FXML
    private TextField idField, pictureField, nameField;

    @FXML
    private TextArea descriptionArea, setsRepsArea;

    @FXML
    private ComboBox<String> categoryComboBox, genderComboBox;

    private String[] muscleGroup = {"trapsFront", "chest", "shouldersFront", "abdominal", "oblique", "biceps", "forearmFront", "quadriceps", "calfFront", "trapsUpBack", "trapsDownBack", "shoulderBack","lats","glutes","back","hamstring","calfBack","triceps","forearmBack"};

    private String[] genderChoice = {"male"," female"};

    @FXML
    private Button chooseButton, createButton, updateButton, deleteButton, findExerciseButton, createExerciseButton, updateExerciseButton, deleteExerciseButton;

    private byte[] selectedImage;

    private FXMLLoader root;

    private Stage stage;

    private Scene scene;


    @FXML
    public void goToHome(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/admin.fxml"));
        scene = new Scene(root.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void goToDiets(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/diets-admin.fxml"));
        scene = new Scene(root.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void goToDishes(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/dishes-admin.fxml"));
        scene = new Scene(root.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToExercise(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/exercise-admin.fxml"));
        scene = new Scene(root.load());
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

    @FXML
    public void choosePicture() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.webp", "*.gif", "*.mp4"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try {

                selectedImage = Files.readAllBytes(selectedFile.toPath());
                pictureField.setText(selectedFile.getPath());

            } catch (IOException e) {
                Logger.getLogger(DishesAdminController.class.getName()).log(Level.SEVERE, null, e);
            }

        }

    }


    @FXML
    public void findExercise() {

        ExerciseDAOImpl exerciseDAOImpl = new ExerciseDAOImpl();

        Exercise foundExercise = exerciseDAOImpl.findById(Integer.valueOf(idField.getText()));

        nameField.setText(foundExercise.getExerciseName());
        descriptionArea.setText(foundExercise.getExerciseDescription());
        categoryComboBox.setValue(foundExercise.getMuscleCategory());
        setsRepsArea.setText(foundExercise.getSets());
        genderComboBox.setValue(foundExercise.getGender());

    }

    @FXML
    public void createExercise() {

        exerciseManagePane.getChildren().clear();
        clearFields();

        exerciseManagePane.getChildren().addAll(pictureLabel, nameLabel, descriptionLabel, categoryLabel, SetsRepsLabel, pictureField, nameField, descriptionArea, setsRepsArea, categoryComboBox, genderLabel, genderComboBox, chooseButton, createButton);

    }

    @FXML
    public void create() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        ExerciseDAOImpl exerciseDAOImpl = new ExerciseDAOImpl();

        String name = nameField.getText();
        String description = descriptionArea.getText();
        String muscleCategory = categoryComboBox.getValue();
        String sets = setsRepsArea.getText();
        String gender = genderComboBox.getValue();

        Exercise exercise = exerciseDAOImpl.create(new Exercise(name, description, muscleCategory, selectedImage, sets, gender));

        if (exercise != null) {
            alert.setContentText("The exercise was created successfully! ");
            alert.showAndWait();
            clearFields();
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Failed to create an exercise!");
            alert.showAndWait();

        }

    }

    @FXML
    public void updateExercise() {

        exerciseManagePane.getChildren().clear();
        clearFields();

        exerciseManagePane.getChildren().addAll(idLabel, nameLabel, descriptionLabel, categoryLabel, categoryComboBox, genderLabel, genderComboBox, SetsRepsLabel, idField, nameField, descriptionArea, setsRepsArea, updateButton, findExerciseButton);


    }

    @FXML
    public void update() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        ExerciseDAOImpl exerciseDAOImpl = new ExerciseDAOImpl();

        Integer id = Integer.valueOf(idField.getText());
        String name = nameField.getText();
        String description = descriptionArea.getText();
        String muscleCategory = categoryComboBox.getValue();
        String sets = setsRepsArea.getText();
        String gender = genderComboBox.getValue();

        Exercise updatedExercise = exerciseDAOImpl.update(new Exercise(id, name, description, muscleCategory, sets,gender));

        if (updatedExercise != null) {

            alert.setContentText("The exercise was updated successfully! ");
            alert.showAndWait();
            clearFields();
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Failed to update the exercise!");
            alert.showAndWait();

        }
    }

    @FXML
    public void deleteExercise() {

        exerciseManagePane.getChildren().clear();
        clearFields();

        exerciseManagePane.getChildren().addAll(idLabel, nameLabel, descriptionLabel, categoryLabel, SetsRepsLabel, idField, nameField, descriptionArea, setsRepsArea, deleteButton, findExerciseButton,categoryComboBox, genderLabel, genderComboBox);
    }

    @FXML
    public void delete() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        ExerciseDAOImpl exerciseDAOImpl = new ExerciseDAOImpl();

      boolean isDeleted = exerciseDAOImpl.deleteById(Integer.valueOf(idField.getText()));

      if(isDeleted){
          alert.setContentText("The exercise was deleted successfully! ");
          alert.showAndWait();
          clearFields();
      } else {
          alert.setAlertType(Alert.AlertType.ERROR);
          alert.setContentText("Failed to delete the exercise!");
          alert.showAndWait();
      }
    }

    public void clearFields(){

        idField.clear();
        nameField.clear();
        categoryComboBox.setValue(null);
        genderComboBox.setValue((null));
        pictureField.clear();
        setsRepsArea.clear();
        descriptionArea.clear();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image exit = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\exit.png");
        exitView.setImage(exit);

        Image menu = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\menu.png");
        menuView.setImage(menu);

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
        exerciseView.setImage(workout);
        exerciseView.setOnMouseClicked(event -> {
            try {
                goToExercise(new ActionEvent(exerciseView, exerciseView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Image dish = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\dishIdeas.png");
        dishesView.setImage(dish);
        dishesView.setOnMouseClicked(event -> {
            try {
                goToDishes(new ActionEvent(dishesView, dishesView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Image logOut = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\logOut.png");
        logOutView.setImage(logOut);
        logOutView.setOnMouseClicked(event -> {
            try {
                goToSignIn(new ActionEvent(logOutView, logOutView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        for(int i =0; i < muscleGroup.length; i++){
            categoryComboBox.getItems().add(muscleGroup[i]);
        }

        for(int i =0; i < genderChoice.length; i++){
            genderComboBox.getItems().add(genderChoice[i]);
        }


        exitView.setOnMouseClicked(event -> System.exit(0));

        buttonsPane.setTranslateX(-600);

        menuView.setOnMouseClicked(event -> {

                    TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), buttonsPane);

                    if (buttonsPane.getTranslateX() != 0) {
                        translateTransition.setToX(0);
                    } else {
                        translateTransition.setToX(-600);
                    }
                    translateTransition.play();
                }
        );

    }
}
