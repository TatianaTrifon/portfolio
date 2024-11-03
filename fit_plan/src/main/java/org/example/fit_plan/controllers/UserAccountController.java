package org.example.fit_plan.controllers;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.fit_plan.dao.implimentations.DietDAOImpl;
import org.example.fit_plan.dao.implimentations.UserAccountDAOImpl;
import org.example.fit_plan.dao.implimentations.UserDAOImpl;
import org.example.fit_plan.model.Diet;
import org.example.fit_plan.model.User;
import org.example.fit_plan.model.UserAccount;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class UserAccountController implements Initializable {


    @FXML
    private ImageView exitImage, menuImage, homeView, workoutView, dietsView, dishView, progressView, settingsView, logOutView;

    @FXML
    private AnchorPane mainPane, iconPane, buttonsPane, caloriesResultPane;

    @FXML
    private TextField ageField, heightField, weightField;

    @FXML
    private RadioButton maleRadioButton, femaleRadioButton;

    @FXML
    private ComboBox<String> activityComboBox;

    private final String[] activities = {"Sedentary: little or no exercise",
            "Light: exercise 1-3 times/week",
            "Moderate: exercise 4-5 times/week",
            "Active: daily exercise or intense exercise 3-4 times/week",
            "Very active: intense exercise 6-7 times/week",
            "Extra active: very intense exercise daily, or physical job"};

    @FXML
    private Button calculateButton;

    @FXML
    ScrollPane pageScrollPane;

    @FXML
    private Label welcomeLabel, maintainWeightLabel, loseWeightLabel, putWeightLabel, maintainWeight, loseWeight, putOnWeight, recommendedDietsLabel;

    @FXML
    private GridPane pageGridPane;

    @FXML
    private VBox scrollContent;

    @FXML
    private HBox dietContainer;


    private Parent root;

    private Stage stage;

    private Scene scene;

    private int userId;
    private String username;

    public void setUserId(int userId) {
        this.userId = userId;

    }

    public void setUsername(String username) {
        this.username = username;
        welcomeLabel.setText("Welcome, " + username + "!");
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


        for (int i = 0; i < activities.length; i++) {
            activityComboBox.getItems().add(activities[i]);
        }

        caloriesResultPane.getChildren().clear();

    }

    @FXML
    public void calculateCalories() {

            dietContainer.getChildren().clear();
        caloriesResultPane.getChildren().clear();


        double bmr;


        UserAccountDAOImpl userAccountDAOImpl = new UserAccountDAOImpl();

        int age = Integer.parseInt(ageField.getText());
        String gender = maleRadioButton.isSelected() ? "Male" : "Female";
        double height = Double.parseDouble(heightField.getText());
        double weight = Double.parseDouble(weightField.getText());
        String activity = activityComboBox.getValue();

        UserAccount existingUser = userAccountDAOImpl.findById(userId);

        if(existingUser == null) {
            UserAccount userAccount = new UserAccount(userId, age, gender, height, weight, activity);
            userAccountDAOImpl.create(userAccount);
        }

        if (gender.equalsIgnoreCase("Male")) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }

        double activityFactor = getActivityFactor(activity);

        double maintainWeightValue = bmr * activityFactor;
        double loseWeightValue = maintainWeightValue * 0.85;
        double putWeightValue = maintainWeightValue * 1.15;

        maintainWeightLabel.setText(String.format("%.2f", maintainWeightValue) + " kcal");
        loseWeightLabel.setText(String.format("%.2f", loseWeightValue) + " kcal");
        putWeightLabel.setText(String.format("%.2f", putWeightValue) + " kcal");

        caloriesResultPane.getChildren().addAll(maintainWeightLabel, loseWeightLabel, putWeightLabel, maintainWeight, loseWeight, putOnWeight,recommendedDietsLabel);

        showRecommendedDiets();

    }

    public double getActivityFactor(String activityLevel) {
        return switch (activityLevel) {
            case "Sedentary: little or no exercise" -> 1.2;
            case "Light: exercise 1-3 times/week" -> 1.375;
            case "Moderate: exercise 4-5 times/week" -> 1.55;
            case "Active: daily exercise or intense exercise 3-4 times/week" -> 1.725;
            case "Very active: intense exercise 6-7 times/week" -> 1.9;
            case "Extra active: very intense exercise daily, or physical job" -> 2.0;
            default -> 1.0;
        };
    }

    public void showRecommendedDiets() {


        DietDAOImpl dietDAOImpl = new DietDAOImpl();
        List<Diet> diets = dietDAOImpl.findRecommendedDiets();

        dietContainer.setSpacing(20);


        for (Diet diet : diets) {
            VBox dietBox = new VBox(10);
            dietBox.setStyle("-fx-border-color: #ccc; -fx-border-width: 1; -fx-padding: 10; -fx-background-color: #f9f9f9;");
            dietBox.setMaxHeight(250);
            dietBox.setMaxWidth(275);


            Image image = new Image(new ByteArrayInputStream(diet.getPicture()));
            ImageView picture = new ImageView(image);
            picture.setFitHeight(200);
            picture.setFitWidth(275);


            Label dietName = new Label(diet.getDietName());
            dietName.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
            dietName.setWrapText(true);

            Label dietDescription = new Label(diet.getDietDescription());
            dietDescription.setStyle("-fx-font-size: 14;");
            dietDescription.setWrapText(true);

            Label dietCategory = new Label(diet.getDietCategory());
            dietCategory.setStyle("-fx-font-size: 14; -fx-text-fill: #666;");
            dietCategory.setWrapText(true);

            dietBox.getChildren().addAll(picture, dietName, dietDescription, dietCategory);

            VBox.setVgrow(dietName, Priority.ALWAYS);
            VBox.setVgrow(dietDescription, Priority.ALWAYS);
            VBox.setVgrow(dietCategory, Priority.ALWAYS);

            dietContainer.getChildren().add(dietBox);
        }

        dietContainer.setSpacing(20);
        dietContainer.setFillHeight(false);
    }
}

