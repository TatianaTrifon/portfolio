package org.example.fit_plan.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.fit_plan.dao.DishDAO;
import org.example.fit_plan.dao.implimentations.DishDAOImpl;
import org.example.fit_plan.dao.implimentations.UserAccountDAOImpl;
import org.example.fit_plan.model.Diet;
import org.example.fit_plan.model.Dish;
import org.example.fit_plan.model.UserAccount;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserDishController implements Initializable {

    @FXML
    private ImageView exitImage, menuImage, homeView, workoutView, dietsView, dishView, progressView, settingsView, logOutView;

    @FXML
    private AnchorPane mainPane, iconPane, buttonsPane, caloriesResultPane;

    @FXML
    ScrollPane pageScrollPane;

    @FXML
    private JFXButton homeButton, workoutButton, dietsButton, dishButton, progressButton, settingsButton, logOutButton;

    @FXML
    private VBox scrollContent;

    @FXML
    private FlowPane dishContainer;

    @FXML
    private FlowPane ingredientsBox;

    @FXML
    private TextField searchField, searchDishField;

    @FXML
    private Button addButton, clearButton, searchButton;

    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    private int userId;

    List<String> selectedIngredients = new ArrayList<>();


    public void setUserId(int userId) {
        this.userId = userId;

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

        UserProgressController controller = root.getController();

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

    @FXML
    public void addIngredientButton() {

        String ingredient = searchField.getText();
        selectedIngredients.add(ingredient);


        Button ingredientButton = new Button(ingredient);
        ingredientButton.setStyle("-fx-background-color: #e0e0e0; -fx-text-fill: #333; -fx-min-width: 80; -fx-min-height: 32; -fx-opacity: 0.7; -fx-font-size: 14;");

        filterDishes();

        ingredientButton.setOnAction(event -> {
            selectedIngredients.remove(ingredient);
            ingredientsBox.getChildren().remove(ingredientButton);
            filterDishes();
        });

        ingredientsBox.getChildren().add(ingredientButton);

    }

    @FXML
    public void clearIngredientsButton() {

        DishDAOImpl dishDAO = new DishDAOImpl();

        selectedIngredients.clear();
        ingredientsBox.getChildren().clear();
        showDishes(dishDAO.findAll());
    }

    @FXML
    public void searchDietButton() {

        DishDAOImpl dishDAO = new DishDAOImpl();

        showDishes(dishDAO.findByName(searchDishField.getText()));

        searchDishField.clear();
    }


    private void filterDishes() {


        DishDAOImpl dishDAO = new DishDAOImpl();

        List<Dish> filteredDishes = new ArrayList<>(dishDAO.findAll());

        for (String ingredient : selectedIngredients) {
            filteredDishes.retainAll(dishDAO.findByIngredient(ingredient));
        }

        showDishes(filteredDishes);
        searchField.clear();
    }


    public void goToDishDetails(Dish dish) {

        try {
            root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/dish-details.fxml"));

            Stage currentStage = (Stage) mainPane.getScene().getWindow();

            Stage dishDetailsStage = new Stage();
            dishDetailsStage.setScene(new Scene(root.load()));

            DishDetailsController controller = root.getController();
            controller.setDish(dish);
            controller.setUserId(userId);
            controller.setPreviousStage(currentStage);

            currentStage.hide();
            dishDetailsStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showDishes(List<Dish> dishes) {
        dishContainer.getChildren().clear();
        dishContainer.setHgap(25);
        dishContainer.setVgap(20);


        double dishBoxWidth = 350;
        double dishBoxHeight = 500;

        for (Dish dish : dishes) {
            VBox dishBox = new VBox(10);
            dishBox.setStyle("-fx-border-color: #ccc; -fx-border-width: 1; -fx-padding: 10; -fx-background-color: #f9f9f9;");
            dishBox.setPrefWidth(dishBoxWidth);
            dishBox.setPrefHeight(dishBoxHeight);
            dishBox.setMinWidth(dishBoxWidth);
            dishBox.setMinHeight(dishBoxHeight);
            dishBox.setMaxWidth(dishBoxWidth);
            dishBox.setMaxHeight(dishBoxHeight);

            dishBox.setClip(new Rectangle(dishBoxWidth , dishBoxHeight - 7));

            Image image = new Image(new ByteArrayInputStream(dish.getPicture()));
            ImageView picture = new ImageView(image);
            picture.setFitHeight(300);
            picture.setFitWidth(325);

            Label dietName = new Label(dish.getDishName());
            dietName.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
            dietName.setWrapText(true);



            Text ingredients = new Text(dish.getIngredients());
            ingredients.setStyle("-fx-font-size: 14;");
            ingredients.setWrappingWidth(280);



            Label calories = new Label(String.valueOf(dish.getCalories()) + "kcal");
            calories.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
            calories.setWrapText(true);


            dishBox.getChildren().addAll(picture, dietName, ingredients,  calories);


            dishBox.setOnMouseClicked(event -> goToDishDetails(dish));

            dishContainer.getChildren().add(dishBox);
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pageScrollPane.setFitToWidth(true);
        pageScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Disable horizontal scrolling


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
                goToSignIn(new ActionEvent(logOutView, logOutView.getScene().getWindow()));
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

        DishDAOImpl dishDAOImpl = new DishDAOImpl();

        showDishes(dishDAOImpl.findAll());

    }

}
