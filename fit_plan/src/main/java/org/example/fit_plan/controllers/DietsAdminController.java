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
import org.example.fit_plan.dao.implimentations.DietDAOImpl;
import org.example.fit_plan.model.Diet;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DietsAdminController implements Initializable {

    @FXML
    private AnchorPane mainPane, iconPane, buttonsPane;

    @FXML
    private ImageView menuView, exitView, homeView, dietsView, dishesView, exerciseView, logOutView;

    @FXML
    private JFXButton homeButton, dietsButton, dishesButton, exerciseButton, logOutButton;

    @FXML
    private AnchorPane dietManagePane;

    @FXML
    private TextField idField, pictureField, nameField;

    @FXML
    private Label idLabel, pictureLabel, nameLabel, descriptionLabel, categoryLabel, allowedFoodLabel, forbiddenFoodLabel;

    @FXML
    private TextArea descriptionArea, allowedFoodArea, forbiddenFoodArea;

    @FXML
    private ComboBox<String> categoryComboBox;

    private String[] dietCategories = {"Weight-Loss Diets", "Diabetes Diets", "Healthy eating Diets", "Plant-Based Diets", "Bone and Joint health diets", "Heart-healthy Diets"};

    @FXML
    private Button createButton, updateButton, deleteButton, createDietButton, updateDietButton, deleteDietButton, chooseButton, findDietButton;

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
    public void goToDishes() {
    }

    @FXML
    public void goToExercise() {
    }

    @FXML
    public void goToUserAccount() {
    }


    @FXML
    public void choosePicture() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.webp"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try {

                selectedImage = Files.readAllBytes(selectedFile.toPath());
                pictureField.setText(selectedFile.getPath());
            } catch (IOException e) {
                Logger.getLogger(DietsAdminController.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }


    @FXML
    public void createDiet() {

        dietManagePane.getChildren().clear();
        clearFields();

        dietManagePane.getChildren().addAll(pictureLabel, nameLabel, descriptionLabel, categoryLabel, allowedFoodLabel, forbiddenFoodLabel, pictureField, nameField, descriptionArea, categoryComboBox, allowedFoodArea, forbiddenFoodArea, createButton, chooseButton);


    }

    @FXML
    public void create() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        DietDAOImpl dietDAOImpl = new DietDAOImpl();

        String name = nameField.getText();
        String description = descriptionArea.getText();
        String category = categoryComboBox.getValue();
        String allowed = allowedFoodArea.getText();
        String forbidden = forbiddenFoodArea.getText();

        Diet diet = dietDAOImpl.create(new Diet(selectedImage, name, description, category, allowed, forbidden));

        if (diet != null) {
            alert.setContentText("The diet was created successfully!");
            alert.showAndWait();
            clearFields();
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Failed to create a diet");
            alert.showAndWait();
        }
    }

    @FXML
    public void findDiet() {

        DietDAOImpl dietDAOImpl = new DietDAOImpl();
        Alert alert = new Alert(Alert.AlertType.ERROR);

        int id = Integer.parseInt(idField.getText());

        Diet foundDiet = dietDAOImpl.findById(id);

        if (foundDiet != null) {

            nameField.setText(foundDiet.getDietName());
            descriptionArea.setText(foundDiet.getDietDescription());
            categoryComboBox.setValue(foundDiet.getDietCategory());
            allowedFoodArea.setText(foundDiet.getAllowedFood());
            forbiddenFoodArea.setText(foundDiet.getForbiddenFood());

        } else {
            alert.setContentText("Failed to find any diet!");
            alert.showAndWait();
        }


    }

    @FXML
    public void updateDiet() {

        dietManagePane.getChildren().clear();
        clearFields();

        dietManagePane.getChildren().addAll(idLabel, pictureLabel, nameLabel, descriptionLabel, categoryLabel, allowedFoodLabel, forbiddenFoodLabel, idField, pictureField, nameField, descriptionArea, categoryComboBox, allowedFoodArea, forbiddenFoodArea, updateButton, chooseButton, findDietButton);

    }

    @FXML
    public void update() {

        DietDAOImpl dietDAOImpl = new DietDAOImpl();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        int dietId = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String description = descriptionArea.getText();
        String category = categoryComboBox.getValue();
        String allowed = allowedFoodArea.getText();
        String forbidden = forbiddenFoodArea.getText();

        Diet updatedDiet = dietDAOImpl.update(new Diet(dietId, selectedImage, name, description, category, allowed, forbidden));

        if (updatedDiet != null) {
            alert.setContentText("The Diet is updated successfully!");
            alert.showAndWait();
            clearFields();
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Failed to update the Diet!");
            alert.showAndWait();
        }

    }

    @FXML
    public void deleteDiet() {

        dietManagePane.getChildren().clear();
        clearFields();

        dietManagePane.getChildren().addAll(idLabel, pictureLabel, nameLabel, descriptionLabel, categoryLabel, allowedFoodLabel, forbiddenFoodLabel, idField, pictureField, nameField, descriptionArea, categoryComboBox, allowedFoodArea, forbiddenFoodArea, deleteButton,findDietButton);

    }

    @FXML
    public void delete() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        DietDAOImpl dietDAOImpl = new DietDAOImpl();
        int id = Integer.parseInt(idField.getText());

        boolean isDeleted = dietDAOImpl.deleteById(id);

        if (isDeleted) {
            alert.setContentText("The Diet was deleted successfully!");
            alert.showAndWait();
            clearFields();
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Failed to delete the Diet!");
            alert.showAndWait();
        }

    }


    public void clearFields() {
        if (idField != null) {
            idField.clear();
        }
        pictureField.clear();
        nameField.clear();
        descriptionArea.clear();
        categoryComboBox.setValue(null);
        allowedFoodArea.clear();
        forbiddenFoodArea.clear();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image exit = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\exit.png");
        exitView.setImage(exit);

        Image menu = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\menu.png");
        menuView.setImage(menu);

        Image home = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\home.png");
        homeView.setImage(home);

        Image diets = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\diets.png");
        dietsView.setImage(diets);

        Image workout = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\workoutPlan.png");
        exerciseView.setImage(workout);

        Image dish = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\dishIdeas.png");
        dishesView.setImage(dish);

        Image logOut = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\logOut.png");
        logOutView.setImage(logOut);

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

        for (int i = 0; i < dietCategories.length; i++) {
            categoryComboBox.getItems().add(dietCategories[i]);
        }

    }
}
