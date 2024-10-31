package org.example.fit_plan.controllers;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.fit_plan.dao.implimentations.DietDAOImpl;
import org.example.fit_plan.dao.implimentations.UserAccountDAOImpl;
import org.example.fit_plan.model.Diet;
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
    private AnchorPane mainPane, iconPane, buttonsPane;

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
    private Label welcomeLabel;

    @FXML
    private GridPane pageGridPane;



    private Parent root;

    private Stage stage;

    private Scene scene;

    private int userId;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pageScrollPane = new ScrollPane(mainPane);
        pageScrollPane.setFitToWidth(true);

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
        welcomeLabel.setText("Welcome !");

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
    }

    @FXML
    public void calculateCalories() {

        UserAccountDAOImpl userAccountDAOImpl = new UserAccountDAOImpl();

        int age = Integer.parseInt(ageField.getText());
        String gender;

        if (maleRadioButton.isSelected()) {
            gender = maleRadioButton.getText();
        } else {
            gender = femaleRadioButton.getText();
        }
        double height = Double.parseDouble(heightField.getText());
        double weight = Double.parseDouble(weightField.getText());
        String activity = activityComboBox.getValue();

        UserAccount userAccount = new UserAccount(userId, age, gender, height, weight, activity);
        userAccountDAOImpl.create(userAccount);

        DietDAOImpl dietDAOImpl = new DietDAOImpl();

        List<Diet> diets = dietDAOImpl.findRecommendedDiets();

        pageGridPane = new GridPane();

        int columnIndex = 0;

        for (Diet diet : diets) {

            Image image = new Image(new ByteArrayInputStream(diet.getPicture()));
            ImageView picture = new ImageView(image);
            picture.setFitWidth(100);
            picture.setFitHeight(100);
            picture.setPreserveRatio(true);

            Label dietName = new Label(diet.getDietName());
            Label dietDescription = new Label(diet.getDietDescription());
            Label dietCategory = new Label(diet.getDietCategory());

            pageGridPane.add(picture, columnIndex, 0);
            pageGridPane.add(dietName, columnIndex, 1);
            pageGridPane.add(dietDescription, columnIndex, 2);
            pageGridPane.add(dietCategory, columnIndex, 3);

            columnIndex++;

        }
mainPane.getChildren().add(pageGridPane);

    }


}

