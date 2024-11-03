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
import org.example.fit_plan.dao.implimentations.DishDAOImpl;
import org.example.fit_plan.model.Dish;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DishesAdminController implements Initializable {


    @FXML
    private AnchorPane mainPane, iconPane, buttonsPane, dishManagePane;

    @FXML
    private ImageView menuView, exitView, homeView, dietsView, dishesView, exerciseView, logOutView;

    @FXML
    private JFXButton homeButton, dietsButton, dishesButton, exerciseButton, logOutButton;

    @FXML
    private Label idLabel, pictureLabel, nameLabel, ingredientsLabel, caloriesLabel, instructionsLabel, nutrientsLabel;

    @FXML
    private TextField idField, pictureField, nameField, caloriesField;

    @FXML
    private TextArea ingredientsArea, instructionArea, nutrientsArea;

    @FXML
    private Button chooseButton, createButton, updateButton, deleteButton, findDishButton, createDishButton, updateDishButton, deleteDishButton;

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
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.webp"));

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
    public void createDish() {

        dishManagePane.getChildren().clear();

        clearFields();

        dishManagePane.getChildren().addAll(pictureLabel, nameLabel, ingredientsLabel, caloriesLabel, instructionsLabel, nutrientsLabel, pictureField, nameField, caloriesField, ingredientsArea, instructionArea, nutrientsArea, chooseButton, createButton);

    }

    @FXML
    public void create() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        DishDAOImpl dishDAOImpl = new DishDAOImpl();

        String name = nameField.getText();
        String ingredients = ingredientsArea.getText();
        String instructions = instructionArea.getText();
        double calories = Double.parseDouble(caloriesField.getText());
        String nutrients = nutrientsArea.getText();

        Dish dish = dishDAOImpl.create(new Dish(selectedImage, name, ingredients, instructions, calories, nutrients));

        if (dish != null) {
            alert.setContentText("The dish was created successfully!");
            alert.showAndWait();
            clearFields();
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Failed to create a dish!");
            alert.showAndWait();
        }
    }

    @FXML
    public void updateDish() {

        dishManagePane.getChildren().clear();
        clearFields();

        dishManagePane.getChildren().addAll(idLabel, nameLabel, ingredientsLabel, caloriesLabel, instructionsLabel, nutrientsLabel, idField, nameField, caloriesField, ingredientsArea, instructionArea, nutrientsArea, updateButton, findDishButton);
    }

    @FXML
    public void update() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        DishDAOImpl dishDAOImpl = new DishDAOImpl();

        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String ingredients = ingredientsArea.getText();
        String instructions = instructionArea.getText();
        double calories = Double.parseDouble(caloriesField.getText());
        String nutrients = nutrientsArea.getText();

        Dish updatedDish = dishDAOImpl.update(new Dish(id, name, ingredients, instructions, calories, nutrients));

        if (updatedDish != null) {
            alert.setContentText("The Dish was upgraded successfully!");
            alert.showAndWait();
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Failed to update the Dish!");
            alert.showAndWait();
        }
    }

    @FXML
    public void deleteDish() {

        dishManagePane.getChildren().clear();
        clearFields();

        dishManagePane.getChildren().addAll(idLabel, nameLabel, ingredientsLabel, caloriesLabel, instructionsLabel, nutrientsLabel, idField, nameField, caloriesField, ingredientsArea, instructionArea, nutrientsArea, deleteButton, findDishButton);
    }

    @FXML
    public void delete() {

        DishDAOImpl dishDAOImpl = new DishDAOImpl();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        boolean isDeleted = dishDAOImpl.deleteById(Integer.valueOf(idField.getText()));

        if (isDeleted) {
            alert.setContentText("The Dish is deleted successfully!");
            alert.showAndWait();
            clearFields();

        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Failed to delete the Dish!");
            alert.showAndWait();
        }


    }

    @FXML
    public void findDish() {

        DishDAOImpl dishDAOImpl = new DishDAOImpl();

        Dish foundDish = dishDAOImpl.findById(Integer.valueOf(idField.getText()));

        nameField.setText(foundDish.getDishName());
        ingredientsArea.setText(foundDish.getIngredients());
        instructionArea.setText(foundDish.getInstructions());
        caloriesField.setText(String.valueOf(foundDish.getCalories()));
        nutrientsArea.setText(foundDish.getNutrients());

    }

    public void clearFields() {

        if (idField != null) {
            idField.clear();
        }
        pictureField.clear();
        nameField.clear();
        ingredientsArea.clear();
        instructionArea.clear();
        caloriesField.clear();
        nutrientsArea.clear();

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
